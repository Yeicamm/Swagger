package com.electiva2.grupo3.servicio.impl;

import com.electiva2.grupo3.DTO.RespuestaDto;
import com.electiva2.grupo3.entity.Respuesta;
import com.electiva2.grupo3.entity.Solicitud;
import com.electiva2.grupo3.entity.Usuario;
import com.electiva2.grupo3.repository.RespuestaRepository;
import com.electiva2.grupo3.repository.SolicitudRepository;
import com.electiva2.grupo3.servicio.RespuestaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class RespuestaServiceImpl implements RespuestaService {

    @Autowired
    private RespuestaRepository respuestaRepository;

    @Autowired
    private SolicitudRepository solicitudRepository;

    @Override
    public List<Respuesta> getAllRespuestas() {
        return respuestaRepository.findAll();
    }

    @Override
    public Respuesta getRespuestaById(Long id) {
        return respuestaRepository.findById(id).orElse(null);
    }

    @Override
    public Object createRespuesta(RespuestaDto respuesta) {
        respuestaRepository.insertarRespuestaConQuery(respuesta.getDescripcion(), respuesta.getIdUsuario(), respuesta.getIdSolicitud());

        return "creado";
    }


    /*
    @Override
    public Object createRespuesta(RespuestaDto respuestaDto) {

        try {
            Respuesta respuesta = new Respuesta();

            Usuario usuario = new Usuario();
            usuario.setId(respuestaDto.getIdUsuario());


            Optional<Solicitud> optionalSolicitud = solicitudRepository.findById(respuestaDto.getIdSolicitud());

            Solicitud solicitud = new Solicitud();
            if (optionalSolicitud.isPresent()){
                solicitud.setId(respuestaDto.getIdSolicitud());
                solicitud.setPeticion(optionalSolicitud.get().getPeticion());
                solicitud.setTipoPeticion(optionalSolicitud.get().getTipoPeticion());
                solicitud.setEstado(optionalSolicitud.get().getEstado());
                solicitud.setUsuario(usuario);
            }else {
                return "nononono";
            }

            respuesta.setDescripcion(respuestaDto.getDescripcion());
            respuesta.setUsuario(usuario);
            respuesta.setSolicitud(solicitud);

            solicitudRepository.save(solicitud);
            respuestaRepository.save(respuesta);

            return respuestaDto;
        }catch (Exception e){
            return e.getMessage();
        }

    }

     */

    @Override
    public Object updateRespuesta(Long id, RespuestaDto respuesta) {
        Respuesta existRespuesta = respuestaRepository.findById(id).orElse(null);

        if (existRespuesta != null){

            Usuario usuario = new Usuario();
            usuario.setId(respuesta.getIdUsuario());

            Optional<Solicitud> solicitudOptional = solicitudRepository.findById(respuesta.getIdSolicitud());
            Solicitud solicitud = new Solicitud();
            if (solicitudOptional.isPresent()){

                solicitud.setId(respuesta.getIdSolicitud());
                solicitud.setPeticion(solicitudOptional.get().getPeticion());
                solicitud.setTipoPeticion(solicitudOptional.get().getTipoPeticion());
                solicitud.setEstado(solicitudOptional.get().getEstado());
                existRespuesta.setSolicitud(solicitud);
            }

            existRespuesta.setUsuario(usuario);

            respuestaRepository.save(existRespuesta);

            return "Se actualizo correctamente";

        }
        return "No se puede actualizar";
    }

}
