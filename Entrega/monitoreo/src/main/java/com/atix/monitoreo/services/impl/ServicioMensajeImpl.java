package com.atix.monitoreo.services.impl;

import com.atix.monitoreo.messages.MessageResponse;
import com.atix.monitoreo.messages.MessagesResponse;
import com.atix.monitoreo.models.SistemaMonitoreo;
import com.atix.monitoreo.services.ServicioMensajes;
import org.springframework.stereotype.Service;

@Service
public class ServicioMensajeImpl implements ServicioMensajes {

    @Override
    public MessageResponse mandarMensaje(Integer mensaje) throws NumberFormatException {
        SistemaMonitoreo.conseguirInstancia().actualizarCola(mensaje);
        return new MessageResponse(mensaje);
    }

    @Override
    public MessagesResponse conseguirMensajesDelSistema() {
        return new MessagesResponse(
                SistemaMonitoreo.conseguirInstancia().getCola());
    }


}
