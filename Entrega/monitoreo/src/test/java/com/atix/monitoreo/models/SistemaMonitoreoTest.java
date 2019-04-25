package com.atix.monitoreo.models;

import com.atix.monitoreo.utils.Aleatoridad;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SistemaMonitoreoTest {

    @Test
    public void testCola() {
        SistemaMonitoreo sistemaMonitoreo = SistemaMonitoreo.conseguirInstancia();
        Sensor sensor = new Sensor(sistemaMonitoreo);
        int numeroUno = Aleatoridad.conseguirInstancia().algoritmoAleatorio(1,9999);
        int numeroDos = Aleatoridad.conseguirInstancia().algoritmoAleatorio(1,9999);
        int numeroTres = Aleatoridad.conseguirInstancia().algoritmoAleatorio(1,9999);
        int numeroCuatro = Aleatoridad.conseguirInstancia().algoritmoAleatorio(1,9999);
        sensor.generarNumero(numeroUno);
        sensor.generarNumero(numeroDos);
        sensor.generarNumero(numeroTres);
        sensor.generarNumero(numeroCuatro);
        System.out.println(SistemaMonitoreo.conseguirInstancia().getCola());

        if(sistemaMonitoreo.getCola().peek() == 100){ //Test va a conseguir un numero 100
            sistemaMonitoreo.getCola().poll();        //solamente si se corren todos los tests juntos
        }

        assertEquals(numeroUno, sistemaMonitoreo.getCola().poll().intValue());
        assertEquals(numeroDos, sistemaMonitoreo.getCola().poll().intValue());
        assertEquals(numeroTres, sistemaMonitoreo.getCola().poll().intValue());
        assertEquals(numeroCuatro, sistemaMonitoreo.getCola().poll().intValue());
        assertTrue(sistemaMonitoreo.getCola().isEmpty());
    }

    @Test
    public void testAnomaliaS() {
        int constanteS = 94;
        SistemaMonitoreo sistemaMonitoreo = SistemaMonitoreo.conseguirInstancia(constanteS, 0);
        Sensor sensor = new Sensor(sistemaMonitoreo);
        sensor.generarNumero(5);
        sensor.generarNumero(100);
        sistemaMonitoreo.ejecutarProceso();
        sistemaMonitoreo.ejecutarProceso();
        assertTrue(ManejoAnomaliaS.conseguirInstancia().isErrorHandled());
    }

    @Test
    public void testAnomaliaM() {
        int constanteM = 65;
        SistemaMonitoreo sistemaMonitoreo = SistemaMonitoreo.conseguirInstancia(0, constanteM);
        Sensor sensor = new Sensor(sistemaMonitoreo);
        sensor.generarNumero(66);
        sensor.generarNumero(66);
        sensor.generarNumero(66);
        sistemaMonitoreo.ejecutarProceso();
        sistemaMonitoreo.ejecutarProceso();
        assertTrue(ManejoAnomaliaM.conseguirInstancia().isErrorHandled());
    }

}