package com.electiva2.grupo3.servicio.impl;

import com.electiva2.grupo3.DTO.SolicitudDto;
import com.electiva2.grupo3.DTO.SolicitudResponseDto;
import com.electiva2.grupo3.entity.Solicitud;
import com.electiva2.grupo3.repository.SolicitudRepository;
import com.electiva2.grupo3.servicio.SolicitudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class SolicitudServiceImpl implements SolicitudService {

    @Autowired
    private SolicitudRepository solicitudRepository;

    @Override
    public List<SolicitudResponseDto> getAllSolicitudes() {

        List<Solicitud> list = solicitudRepository.findAll();

        List<SolicitudResponseDto> solicitudList = new ArrayList<>();

        for (Solicitud solicitud: list) {
            SolicitudResponseDto solicitudResponseDto =
                    SolicitudResponseDto
                            .builder()
                            .id(solicitud.getId())
                            .peticion(solicitud.getPeticion())
                            .tipoPeticion(solicitud.getTipoPeticion())
                            .estado(solicitud.getEstado())
                            .build();
            solicitudList.add(solicitudResponseDto);
        }

        return solicitudList;
    }

    @Override
    public Object getSolicitudById(Long id) {
        Optional<Solicitud> solicitud = solicitudRepository.findById(id);

        if (solicitud.isPresent()) {
            return SolicitudResponseDto
                    .builder()
                    .id(solicitud.get().getId())
                    .tipoPeticion(solicitud.get().getTipoPeticion())
                    .estado(solicitud.get().getEstado())
                    .peticion(solicitud.get().getPeticion())
                    .build();
        }

        return "No se encontro una solicitud con id "+id;
    }

    @Override
    public Object createSolicitud(SolicitudDto solicitud) {


        solicitudRepository.insertarSolicitudConQuery(solicitud.getTipoPeticion(), solicitud.getPeticion(), solicitud.getEstado(),solicitud.getUsuario());

        return "Se creo exitosamente la solicitud";
    }

    @Override
    public Solicitud updateSolicitud(Long id, Solicitud solicitud) {
        solicitud.setId(id);
        return solicitudRepository.save(solicitud);
    }

    @Override
    public void deleteSolicitud(Long id) {
        solicitudRepository.deleteById(id);
    }
}
