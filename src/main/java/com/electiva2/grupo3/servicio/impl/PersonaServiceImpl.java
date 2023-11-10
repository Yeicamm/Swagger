package com.electiva2.grupo3.servicio.impl;

import com.electiva2.grupo3.entity.Persona;
import com.electiva2.grupo3.repository.PersonaRepository;
import com.electiva2.grupo3.servicio.PersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonaServiceImpl implements PersonaService {

    private final PersonaRepository personaRepository;

    @Override
    public Optional<Persona> personaGetById(Long id) {

        Optional<Persona> persona = personaRepository.findById(id);

        if (persona.isPresent()) {
            Persona personaNew = persona.get();
            return Optional.of(personaNew);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public List<Persona> personaGetAll() {
        return new ArrayList<>(personaRepository.findAll());
    }

    @Override
    public Persona createPersona(Persona persona) {

        return personaRepository.save(persona);
    }

    @Override
    public void personaDelete(Long id) {
        personaRepository.deleteById(id);
    }
}
