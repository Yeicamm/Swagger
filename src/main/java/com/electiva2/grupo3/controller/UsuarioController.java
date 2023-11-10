package com.electiva2.grupo3.controller;

import com.electiva2.grupo3.DTO.LoginDto;
import com.electiva2.grupo3.DTO.UsuarioDTO;
import com.electiva2.grupo3.entity.Usuario;
import com.electiva2.grupo3.mapper.UsuarioMapper;
import com.electiva2.grupo3.servicio.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("users")

public class UsuarioController {
    private final UsuarioService usuarioService;
    private UsuarioMapper usuarioMapper;

    @Autowired
    public UsuarioController(UsuarioService usuarioService, UsuarioMapper usuarioMapper) {
        this.usuarioService = usuarioService;
        this.usuarioMapper = usuarioMapper;
    }
    @GetMapping
    public ResponseEntity<List<Usuario>> obtenerTodasLosUsuarios(){
        try {
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            Usuario usuario = usuarioMapper.convertToEntity(usuarioDTO);
            List<Usuario> usuarios = usuarioService.getAllUsers();
            return new ResponseEntity<>(usuarios, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerUsuarioPorId(@PathVariable Long id) {
        try {

            Optional<Usuario> usuarioNew = usuarioService.getByIdUser(id);

            return usuarioNew.map(value ->
                    new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() ->
                    new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping
    public ResponseEntity<Usuario> createUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        try {
            Usuario usuario = usuarioMapper.convertToEntity(usuarioDTO);
            Usuario usuarioNew = usuarioService.createUser(usuario);

            return new ResponseEntity<>(usuarioNew, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<HttpStatus> eliminarUsuario(@PathVariable Long id) {
        try {
            usuarioService.deleteUser(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
