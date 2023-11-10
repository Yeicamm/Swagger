package com.electiva2.grupo3.controller;

import com.electiva2.grupo3.entity.Permiso;
import com.electiva2.grupo3.servicio.PermisoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/permisos")
public class PermisoController {

    @Autowired
    private PermisoService permisoService;

    @GetMapping
    public List<Permiso> getAllPermisos() {
        return permisoService.getAllPermisos();
    }

    @GetMapping("/{id}")
    public Permiso getPermisoById(@PathVariable Long id) {
        return permisoService.getPermisoById(id);
    }

    @PostMapping
    public Permiso createPermiso(@RequestBody Permiso permiso) {
        return permisoService.createPermiso(permiso);
    }

    @PutMapping("/{id}")
    public Permiso updatePermiso(@PathVariable Long id, @RequestBody Permiso permiso) {
        return permisoService.updatePermiso(id, permiso);
    }

    @DeleteMapping("/{id}")
    public void deletePermiso(@PathVariable Long id) {
        permisoService.deletePermiso(id);
    }
}
