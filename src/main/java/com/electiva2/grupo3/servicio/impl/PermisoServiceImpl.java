package com.electiva2.grupo3.servicio.impl;

import com.electiva2.grupo3.entity.Permiso;
import com.electiva2.grupo3.repository.PermisoRepository;
import com.electiva2.grupo3.servicio.PermisoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermisoServiceImpl implements PermisoService {

    @Autowired
    private PermisoRepository permisoRepository;

    @Override
    public List<Permiso> getAllPermisos() {
        return permisoRepository.findAll();
    }

    @Override
    public Permiso getPermisoById(Long id) {
        return permisoRepository.findById(id).orElse(null);
    }

    @Override
    public Permiso createPermiso(Permiso permiso) {
        return permisoRepository.save(permiso);
    }

    @Override
    public Permiso updatePermiso(Long id, Permiso permiso) {
        permiso.setId(id);
        return permisoRepository.save(permiso);
    }

    @Override
    public void deletePermiso(Long id) {
        permisoRepository.deleteById(id);
    }
}
