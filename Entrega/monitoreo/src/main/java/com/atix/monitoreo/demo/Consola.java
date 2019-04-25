package com.atix.monitoreo.demo;

import com.atix.monitoreo.models.SistemaMonitoreo;
import com.atix.monitoreo.models.SistemaSensores;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Consola {

    private static Consola instancia = null;
    private SistemaSensores sistemaSensores;
    private SistemaMonitoreo sistemaMonitoreo;

    private Consola() {
        this.sistemaSensores = SistemaSensores.conseguirInstancia();
        this.sistemaMonitoreo = SistemaMonitoreo.conseguirInstancia();
    }

    public static Consola conseguirInstancia()
    {
        if (instancia == null)
            instancia = new Consola();

        return instancia;
    }

    public void ejecutar() throws java.io.IOException {
        escribirPrimerMensaje();
        permitirEscribir();
    }

    public void permitirEscribir() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Escribir comando: ");
        String s = br.readLine();
        if(s.equals("init")) {
            encenderSistemas();
        } else {
            System.out.print("Argumento invalido");
        }
    }

    public void encenderSistemas() {
            sistemaMonitoreo.run();
            sistemaSensores.run();
    }

    public void escribirPrimerMensaje() {
        System.out.println("Bienvenidos a Sistema de Monitoreo");
        System.out.println("Para iniciar, escribi 'init'");
    }

}
