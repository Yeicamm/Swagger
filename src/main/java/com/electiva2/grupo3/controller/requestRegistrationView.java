package com.electiva2.grupo3.controller;

import com.electiva2.grupo3.DTO.SolicitudDto;
import com.electiva2.grupo3.servicio.SolicitudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class requestRegistrationView {

    @Autowired
    private SolicitudService solicitudService;

    @PostMapping("/login")
    public String request(@RequestParam("tipoPeticion") String tipoPeticion, @RequestParam("peticion") String peticion){

        boolean estado = true;
        Long usuario = 1L;
        SolicitudDto solicitud = new SolicitudDto();

        solicitud.setTipoPeticion(tipoPeticion);
        solicitud.setPeticion(peticion);
        solicitud.setEstado(estado);
        solicitud.setUsuario(usuario);

        // Crea la solicitud
        solicitudService.createSolicitud(solicitud);

        // Redirige a la vista "login"
        return "login";
    }
}
