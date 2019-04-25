package com.atix.monitoreo.messages;

import com.atix.monitoreo.models.Anomalia;

import java.time.LocalDateTime;

public class AnomaliaResponse implements Response {

    private String tipo;
    private String fecha;

    public AnomaliaResponse(Anomalia anomalia) {
        this.tipo = anomalia.getTipo();
        this.fecha = anomalia.getFecha();
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
