package com.electiva2.grupo3.controller;

import com.electiva2.grupo3.DTO.RespuestaDto;
import com.electiva2.grupo3.entity.Respuesta;
import com.electiva2.grupo3.servicio.RespuestaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/respuestas")
public class RespuestaController {

    @Autowired
    private RespuestaService respuestaService;

    @GetMapping
    public List<Respuesta> getAllRespuestas() {
        return respuestaService.getAllRespuestas();
    }

    @GetMapping("/{id}")
    public Respuesta getRespuestaById(@PathVariable Long id) {
        return respuestaService.getRespuestaById(id);
    }

    @PostMapping
    public Object createRespuesta(@RequestBody RespuestaDto respuesta) {
        return respuestaService.createRespuesta(respuesta);
    }

    @PutMapping("/{id}")
    public Object updateRespuesta(@PathVariable Long id, @RequestBody RespuestaDto respuesta) {
        return respuestaService.updateRespuesta(id, respuesta);
    }


}
