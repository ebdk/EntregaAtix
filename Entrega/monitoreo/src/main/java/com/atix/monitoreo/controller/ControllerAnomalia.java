package com.atix.monitoreo.controller;

import com.atix.monitoreo.messages.Response;
import com.atix.monitoreo.services.ServicioAnomalia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("manejo-anomalia")
public class ControllerAnomalia {

    @Autowired
    private ServicioAnomalia servicioAnomalia;

    @GetMapping
    public Response conseguirAnomalias() {
        return servicioAnomalia.devolverAnomalias();
    }

}
