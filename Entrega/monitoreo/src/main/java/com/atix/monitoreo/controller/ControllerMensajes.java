package com.atix.monitoreo.controller;


import com.atix.monitoreo.messages.MessageResponse;
import com.atix.monitoreo.messages.Response;
import com.atix.monitoreo.services.ServicioMensajes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("manejo-mensajes")
public class ControllerMensajes {

    @Autowired
    private ServicioMensajes servicioMensajes;

    @GetMapping
    public Response conseguirMensajes() {
        return servicioMensajes.conseguirMensajesDelSistema();
    }

    @RequestMapping(path="/{numero}")
    public MessageResponse mandarMensaje(@PathVariable("numero") String mensaje) {
        if(mensaje.equals("init")) {
            com.atix.monitoreo.models.SistemaMonitoreo.conseguirInstancia().run();
            return new com.atix.monitoreo.messages.MessageResponse("Procesado");
        }
        return servicioMensajes.mandarMensaje(Integer.parseInt(mensaje));
    }

    @ExceptionHandler({NumberFormatException.class})
    public MessageResponse handleException() {
        return new com.atix.monitoreo.messages.MessageResponse("Error, debes introducir un entero");
    }

}
