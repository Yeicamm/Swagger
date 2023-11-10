package com.electiva2.grupo3.servicio;

import com.electiva2.grupo3.DTO.SolicitudDto;
import com.electiva2.grupo3.DTO.SolicitudResponseDto;
import com.electiva2.grupo3.entity.Solicitud;

import java.util.List;

public interface SolicitudService {
    List<SolicitudResponseDto> getAllSolicitudes();
    Object getSolicitudById(Long id);
    Object  createSolicitud(SolicitudDto solicitud);
    Solicitud updateSolicitud(Long id, Solicitud solicitud);
    void deleteSolicitud(Long id);
}
