package com.electiva2.grupo3.controller;

import com.electiva2.grupo3.entity.Persona;
import com.electiva2.grupo3.servicio.PersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/persona")
@RequiredArgsConstructor
public class PersonaController {
    private final PersonaService personaService;
    @GetMapping
    public ResponseEntity<List<Persona>> obtenerTodasLasPersnas(){
        try {
            List<Persona> personas = personaService.personaGetAll();
            return new ResponseEntity<>(personas, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Persona> obtenerPersonaPorId(@PathVariable Long id) {
        try {
            Optional<Persona> persona = personaService.personaGetById(id);
            return persona.map(value ->
                    new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() ->
                    new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/crear")
    public ResponseEntity<Persona> createPersona(@RequestBody Persona persona) {
        try {
            Persona personaNew = personaService.createPersona(persona);
            return new ResponseEntity<>(personaNew, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<HttpStatus> eliminarUsuario(@PathVariable Long id) {
        try {
            personaService.personaDelete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
