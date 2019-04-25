package com.atix.monitoreo.models;

import static com.atix.monitoreo.models.SistemaMonitoreo.CONSTANTE_S;

public class ManejoAnomaliaS extends ManejoAnomalia {

private static ManejoAnomaliaS instancia = null;

    private ManejoAnomaliaS() {
        super();
        this.setTipo(com.atix.monitoreo.models.TipoAnomalia.M.getCodigo());
    }

    public synchronized static ManejoAnomaliaS conseguirInstancia()
    {
        if (instancia == null)
            instancia = new ManejoAnomaliaS();

        return instancia;
    }



    @Override
    public boolean esAnomalia() {
        return -(SistemaMonitoreo.conseguirInstancia().getMinimo() - SistemaMonitoreo.conseguirInstancia().getMaximo())
                > CONSTANTE_S;
    }

}
