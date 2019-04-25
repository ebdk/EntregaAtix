package com.atix.monitoreo.models;

import com.atix.monitoreo.utils.Aleatoridad;

import java.util.LinkedList;
import java.util.concurrent.ScheduledExecutorService;

import static com.atix.monitoreo.utils.Aleatoridad.NUMERO_GENERADO_MAXIMO;
import static com.atix.monitoreo.utils.Aleatoridad.NUMERO_GENERADO_MINIMO;
import static java.util.concurrent.Executors.newSingleThreadScheduledExecutor;
import static java.util.concurrent.TimeUnit.MILLISECONDS;

public class Sensor implements Runnable {

    private SistemaMonitoreo sistemaANotificar;
    private LinkedList<Integer> numerosGenerados;
    ScheduledExecutorService exec;

    public Sensor(SistemaMonitoreo sistemaANotificar) {
        this.sistemaANotificar = sistemaANotificar;
        this.numerosGenerados = new LinkedList<>();
        this.exec = newSingleThreadScheduledExecutor();
    }

    public void generarNumeroAleatorio() {
        numerosGenerados.add(numeroAleatorio());
        this.notificarSistema();
    }

    public void generarNumero(int numero) {
        numerosGenerados.add(numero);
        this.notificarSistema();
    }

    private int numeroAleatorio() {
        return Aleatoridad.conseguirInstancia().algoritmoAleatorio(NUMERO_GENERADO_MINIMO, NUMERO_GENERADO_MAXIMO);
    }

    public void notificarSistema() {
        this.sistemaANotificar.actualizar(this);
    }

    public int ultimoNumero() {
        return numerosGenerados.poll();
    }

    @Override
    public void run() {
        exec.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                generarNumeroAleatorio();

            }
        }, 0, Aleatoridad.conseguirInstancia().algoritmoAleatorio(450,550), MILLISECONDS);
    }
}
