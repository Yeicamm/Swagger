package com.electiva2.grupo3.servicio;

import com.electiva2.grupo3.DTO.RolDto;
import com.electiva2.grupo3.entity.Rol;

import java.util.List;

public interface RolService {
    Object getRolByDescripcion(String description);
    Rol createRol(RolDto rol);
    Object updateRol(Long id, Rol rol);
}
