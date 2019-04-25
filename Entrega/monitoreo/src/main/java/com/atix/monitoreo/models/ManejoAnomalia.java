package com.atix.monitoreo.models;

import static com.atix.monitoreo.exceptions.AnomaliaException.anomaliaEncontrada;

public abstract class ManejoAnomalia {

    @org.springframework.beans.factory.annotation.Autowired
    private com.atix.monitoreo.services.ServicioAnomalia servicioAnomalia;

    private boolean errorHandled;
    private String tipo;

    public ManejoAnomalia() {
        this.servicioAnomalia = servicioAnomalia;
        this.errorHandled = false;
    }

    public boolean isErrorHandled() {
        return errorHandled;
    }

    public void setErrorHandled(boolean errorHandled) {
        this.errorHandled = errorHandled;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public abstract boolean esAnomalia();

    public void chequearAnomalia() {
        if(esAnomalia()) {
            try {
                anomaliaEncontrada(tipo, java.time.LocalDateTime.now(SistemaMonitoreo.conseguirInstancia().getClock()));
            } catch (Exception exception) {
                exception.printStackTrace();
                setErrorHandled(true);
            }
            SistemaMonitoreo.conseguirInstancia().resetearDatos();
            //servicioAnomalia.guardarAnomalia(new Anomalia(tipo, java.time.LocalDateTime.now(SistemaMonitoreo.conseguirInstancia().getClock())));
        }
    }
}
