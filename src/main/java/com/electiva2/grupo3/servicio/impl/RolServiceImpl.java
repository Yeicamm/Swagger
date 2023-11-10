package com.electiva2.grupo3.servicio.impl;

import com.electiva2.grupo3.DTO.RolDto;
import com.electiva2.grupo3.entity.Rol;
import com.electiva2.grupo3.repository.RolRepository;
import com.electiva2.grupo3.servicio.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolServiceImpl implements RolService {

    @Autowired
    private RolRepository rolRepository;

    @Override
    public Object getRolByDescripcion(String description) {
        Optional<Rol>  rol = rolRepository.findByDescripcion(description);
        if (rol.isPresent()){
            return rol.get();
        }
        return "No se encontro un rol con nombre "+description;
    }

    @Override
    public Rol createRol(RolDto rol) {
        Rol rolCreate = new Rol();
        rolCreate.setEstado(rol.getEstado());
        rolCreate.setDescripcion(rol.getDescripcion());
        return rolRepository.save(rolCreate);
    }

    @Override
    public Object updateRol(Long id, Rol rol) {
        Rol existingRol = rolRepository.findById(id).orElse(null);

        if (existingRol != null) {
            existingRol.setEstado(rol.getEstado());
            existingRol.setDescripcion(rol.getDescripcion());
            return rolRepository.save(existingRol);
        } else {
            return "No se logro actualizar el rol";
        }
    }


}
