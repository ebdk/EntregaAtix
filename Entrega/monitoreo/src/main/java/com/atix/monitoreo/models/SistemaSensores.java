package com.atix.monitoreo.models;

import java.util.ArrayList;
import java.util.List;

public class SistemaSensores {

    private List<Sensor> sensores;
    private SistemaMonitoreo sistemaMonitoreo;
    private static SistemaSensores instancia = null;

    private SistemaSensores() {
        this.sensores = new ArrayList<>();
        this.sistemaMonitoreo = SistemaMonitoreo.conseguirInstancia();
        Sensor sensor1 = new Sensor(sistemaMonitoreo);
        Sensor sensor2 = new Sensor(sistemaMonitoreo);
        Sensor sensor3 = new Sensor(sistemaMonitoreo);
        Sensor sensor4 = new Sensor(sistemaMonitoreo);
        sensores.add(sensor1);
        sensores.add(sensor2);
        sensores.add(sensor3);
        sensores.add(sensor4);
    }

    public synchronized static SistemaSensores conseguirInstancia()
    {
        if (instancia == null)
            instancia = new SistemaSensores();

        return instancia;
    }

    public void run() {
        for (Sensor sensor : sensores) {
            sensor.run();
        }
    }

}
