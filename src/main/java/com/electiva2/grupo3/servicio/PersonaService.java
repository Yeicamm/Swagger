package com.electiva2.grupo3.servicio;

import com.electiva2.grupo3.entity.Persona;

import java.util.List;
import java.util.Optional;

public interface PersonaService {
    Optional<Persona> personaGetById(Long id);
    List<Persona> personaGetAll();
    Persona createPersona(Persona persona);
    void personaDelete(Long id);
}
