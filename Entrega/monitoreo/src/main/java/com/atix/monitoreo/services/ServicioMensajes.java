package com.atix.monitoreo.services;

import com.atix.monitoreo.messages.MessageResponse;
import com.atix.monitoreo.messages.MessagesResponse;

public interface ServicioMensajes {

    MessageResponse mandarMensaje(Integer mensaje) throws NumberFormatException;

    MessagesResponse conseguirMensajesDelSistema();

}
