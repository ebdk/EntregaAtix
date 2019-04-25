package com.atix.monitoreo.models;

import static com.atix.monitoreo.models.SistemaMonitoreo.CONSTANTE_M;

public class ManejoAnomaliaM extends ManejoAnomalia {

    private static ManejoAnomaliaM instancia = null;

    private ManejoAnomaliaM() {
        super();
        this.setTipo(com.atix.monitoreo.models.TipoAnomalia.M.getCodigo());
    }

    public synchronized static ManejoAnomaliaM conseguirInstancia()
    {
        if (instancia == null)
            instancia = new ManejoAnomaliaM();

        return instancia;
    }

    @Override
    public boolean esAnomalia() {
        return SistemaMonitoreo.conseguirInstancia().getPromedio() > CONSTANTE_M &&
                SistemaMonitoreo.conseguirInstancia().getProcesados() >= 2;
    }

}
