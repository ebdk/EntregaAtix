package com.atix.monitoreo.exceptions;

public class AnomaliaException extends RuntimeException {

    public static AnomaliaException anomaliaEncontrada(String tipo, java.time.LocalDateTime hora) {
        throw new AnomaliaException("Anomalia del tipo '%s' encontrada a las %s horas.", tipo, hora.toString());
    }

    private AnomaliaException(String msg, Object... args) {
        super(String.format(msg, args));
    }


}
