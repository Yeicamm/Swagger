package com.electiva2.grupo3.mapper;

import com.electiva2.grupo3.DTO.UsuarioDTO;
import com.electiva2.grupo3.entity.Usuario;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component

public class UsuarioMapper {

    private final ModelMapper modelMapper;

    public UsuarioMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Usuario convertToEntity(UsuarioDTO usuarioDTO) {
        return modelMapper.map(usuarioDTO, Usuario.class);
    }
}
