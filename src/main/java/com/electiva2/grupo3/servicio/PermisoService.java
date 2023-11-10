package com.electiva2.grupo3.servicio;

import com.electiva2.grupo3.entity.Permiso;

import java.util.List;

public interface PermisoService {
    List<Permiso> getAllPermisos();
    Permiso getPermisoById(Long id);
    Permiso createPermiso(Permiso permiso);
    Permiso updatePermiso(Long id, Permiso permiso);
    void deletePermiso(Long id);
}
