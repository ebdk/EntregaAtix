package com.atix.monitoreo.utils;

public class Aleatoridad {

    public static final int NUMERO_GENERADO_MINIMO = 1;
    public static final int NUMERO_GENERADO_MAXIMO = 100;

    private static Aleatoridad instancia = null;

    private Aleatoridad() {
    }

    public synchronized static Aleatoridad conseguirInstancia()
    {
        if (instancia == null)
            instancia = new Aleatoridad();

        return instancia;
    }

    public int algoritmoAleatorio(int min, int max) {
        return min + (int)(Math.random() * ((max - min) + 1));
    }

}
