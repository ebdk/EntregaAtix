package com.atix.monitoreo.services.impl;

import com.atix.monitoreo.messages.MessagesResponse;
import com.atix.monitoreo.models.Anomalia;
import com.atix.monitoreo.repositories.AnomaliaDAO;
import com.atix.monitoreo.services.ServicioAnomalia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioAnomaliaImpl implements ServicioAnomalia {

    @Autowired
    private AnomaliaDAO repositorio;

    @Override
    public void guardarAnomalia(Anomalia anomalia) {
        repositorio.save(anomalia);
    }

    @Override
    public MessagesResponse devolverAnomalias() {
        return new MessagesResponse(repositorio.findAll());
    }
}
