package com.electiva2.grupo3.servicio;

import com.electiva2.grupo3.DTO.RespuestaDto;
import com.electiva2.grupo3.entity.Respuesta;

import java.util.List;

public interface RespuestaService {
    List<Respuesta> getAllRespuestas();
    Respuesta getRespuestaById(Long id);
    Object createRespuesta(RespuestaDto respuesta);
    Object updateRespuesta(Long id, RespuestaDto respuesta);
}
