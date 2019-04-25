package com.atix.monitoreo.services;

import com.atix.monitoreo.messages.MessagesResponse;
import com.atix.monitoreo.models.Anomalia;

public interface ServicioAnomalia {

    void guardarAnomalia(Anomalia anomalia);

    MessagesResponse devolverAnomalias();

}
