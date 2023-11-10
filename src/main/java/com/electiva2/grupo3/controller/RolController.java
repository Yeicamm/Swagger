package com.electiva2.grupo3.controller;

import com.electiva2.grupo3.DTO.RolDto;
import com.electiva2.grupo3.entity.Rol;
import com.electiva2.grupo3.servicio.RolService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/rol")
public class RolController {
    @PersistenceContext
    private EntityManager em;
    @Autowired
    private RolService rolService;

    @GetMapping("/{description}")
    public Object getRolById(@PathVariable String description) {
        return rolService.getRolByDescripcion(description);
    }

    @PostMapping
    public Rol createRol(@RequestBody RolDto rol) {
        return rolService.createRol(rol);
    }

    @PutMapping("/{id}")
    public Object updateRol(@PathVariable Long id, @RequestBody Rol rol) {
        return rolService.updateRol(id, rol);
    }

}
