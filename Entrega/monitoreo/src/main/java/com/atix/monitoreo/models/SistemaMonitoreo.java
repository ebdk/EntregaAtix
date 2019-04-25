package com.atix.monitoreo.models;

import com.atix.monitoreo.utils.Aleatoridad;
import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneOffset;
import java.util.LinkedList;
import java.util.concurrent.ScheduledExecutorService;

import static com.atix.monitoreo.utils.Aleatoridad.NUMERO_GENERADO_MAXIMO;
import static com.atix.monitoreo.utils.Aleatoridad.NUMERO_GENERADO_MINIMO;
import static java.util.concurrent.Executors.newSingleThreadScheduledExecutor;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.slf4j.LoggerFactory.getLogger;

public class SistemaMonitoreo implements Observador, Runnable, CommandLineRunner {

    public static int CONSTANTE_S = ((NUMERO_GENERADO_MAXIMO / 100) * 75); //El 75% del maximo
    public static int CONSTANTE_M = ((NUMERO_GENERADO_MAXIMO / 100) * 55); //El 55% del maximo

    private static final Logger LOG = getLogger(SistemaMonitoreo.class);

    private int promedio;
    private int maximo;
    private int minimo;

    private int sumaAuxiliar;
    private int procesados;

    private int maximoHistorico;
    private int minimoHistorico;
    private int sumalTotal;
    private int procesadosTotal;

    private LinkedList<Integer> cola;
    private ScheduledExecutorService exec;
    private Clock clock;

    private static SistemaMonitoreo instancia = null;

    private SistemaMonitoreo() {
        datosACero();
        this.exec = newSingleThreadScheduledExecutor();
        this.cola = new LinkedList<>();
        this.clock = Clock.fixed(Instant.ofEpochMilli(1429920179000L), ZoneOffset.UTC);
    }

    private SistemaMonitoreo(int constanteS, int constanteM) {
        datosACero();
        this.exec = newSingleThreadScheduledExecutor();
        this.cola = new LinkedList<>();
        this.clock = Clock.fixed(Instant.ofEpochMilli(1429920179000L), ZoneOffset.UTC);
        this.CONSTANTE_S = constanteS;
        this.CONSTANTE_M = constanteM;
    }

    public synchronized static SistemaMonitoreo conseguirInstancia()
    {
        if (instancia == null)
            instancia = new SistemaMonitoreo();

        return instancia;
    }

    public synchronized static SistemaMonitoreo conseguirInstancia(int constanteS, int constanteM)
    {
        if (instancia == null ) {
            instancia = new SistemaMonitoreo(constanteS, constanteM);
        }
        return instancia;
    }

    public LinkedList<Integer> getCola() {
        return cola;
    }

    public int getPromedio() {
        return promedio;
    }

    public int getMaximo() {
        return maximo;
    }

    public int getMinimo() {
        return minimo;
    }

    public int getProcesados() {
        return procesados;
    }

    public java.time.Clock getClock() {
        return clock;
    }

    public synchronized void actualizarCola(int numero) {
        cola.add(numero);
        LOG.info("Received " + numero);
    }

    public synchronized void ejecutarProceso() {
        if(!cola.isEmpty()){
            int numero = cola.poll();
            LOG.info("Processing " + numero);
            actualizarPromedio(numero);
            alcanzoMaximo(numero);
            alcanzoMinimo(numero);
            chequearAnomalia();
        }
    }

    private void chequearAnomalia() {
        SistemaAnomalia.conseguirInstancia().chequearAnomalia();
    }

    private void alcanzoMaximo(int numero) {
        this.maximo = (numero > maximo) ? numero : maximo;
    }

    private void alcanzoMinimo(int numero) {
        this.minimo = (numero < minimo) ? numero : minimo;
    }

    private void actualizarPromedio(int numero) {
        procesados++;
        this.sumaAuxiliar = sumaAuxiliar + numero;
        this.promedio = sumaAuxiliar / procesados;
    }

    void resetearDatos() {
        this.sumalTotal = sumalTotal + sumaAuxiliar;
        this.procesadosTotal = procesadosTotal + procesados;
        this.maximoHistorico = (maximo > maximoHistorico) ? maximo : maximoHistorico;
        this.minimoHistorico = (minimo < minimoHistorico) ? minimo : minimoHistorico;
        datosACero();
    }

    private void datosACero() {
        this.promedio = 0;
        this.maximo = NUMERO_GENERADO_MINIMO;
        this.minimo = NUMERO_GENERADO_MAXIMO;
        this.sumaAuxiliar = 0;
        this.procesados = 0;
    }

    @Override
    public void actualizar(Sensor sensor) {
        this.actualizarCola(sensor.ultimoNumero());
    }

    @Override
    public void run() {
        exec.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                ejecutarProceso();
            }
        }, 0, Aleatoridad.conseguirInstancia().algoritmoAleatorio(27, 33), SECONDS);
    }

    @Override
    public void run(String... args) {
        ejecutarProceso();
    }
}
