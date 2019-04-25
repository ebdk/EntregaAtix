package com.atix.monitoreo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Anomalia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idAnomalia;
    private String tipo;
    private String fecha;

    public Anomalia(String tipo, LocalDateTime fecha) {
        this.tipo = tipo;
        this.fecha = fecha.toString();
    }

    public Long getIdAnomalia() {
        return idAnomalia;
    }
    public String getTipo() {
        return tipo;
    }
    public String getFecha() {
        return fecha;
    }

}
