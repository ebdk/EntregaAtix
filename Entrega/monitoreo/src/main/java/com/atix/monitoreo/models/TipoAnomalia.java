package com.atix.monitoreo.models;

public enum TipoAnomalia {

    S("A", "Diferencia minimo y maximo es mayor a Constante S"),
    M("B", "Promedio es mayor a Constante M");

    private final String codigo;
    private final String descripcion;

    TipoAnomalia(String codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
