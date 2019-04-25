package com.atix.monitoreo.models;

public class SistemaAnomalia {

    private static int CONSTANTE_S = SistemaMonitoreo.CONSTANTE_S;
    private static int CONSTANTE_M = SistemaMonitoreo.CONSTANTE_M;

    private java.util.List<ManejoAnomalia> anomalias;
    private static SistemaAnomalia instancia = null;

    private SistemaAnomalia() {
        this.anomalias = new java.util.ArrayList<>();
        anomalias.add(ManejoAnomaliaS.conseguirInstancia());
        anomalias.add(ManejoAnomaliaM.conseguirInstancia());
    }

    public synchronized static SistemaAnomalia conseguirInstancia()
    {
        if (instancia == null)
            instancia = new SistemaAnomalia();

        return instancia;
    }

    public void chequearAnomalia() {
        for(ManejoAnomalia manejoAnomalia : anomalias) {
            manejoAnomalia.chequearAnomalia();
        }
    }

}
