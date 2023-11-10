package com.electiva2.grupo3.servicio.impl;

import com.electiva2.grupo3.entity.Usuario;
import com.electiva2.grupo3.repository.UsuarioRepository;
import com.electiva2.grupo3.servicio.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository usuarioRepository;
    @Override
    public Optional<Usuario> getByIdUser(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);

        if (usuario.isPresent()) {
            Usuario usuarioNew = usuario.get();
            return Optional.of(usuarioNew);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public List<Usuario> getAllUsers() {
        return new ArrayList<>(usuarioRepository.findAll());
    }

    @Override
    public Usuario createUser(Usuario usuario) {
        return usuarioRepository.save(usuario);

    }

    @Override
    public void deleteUser(Long id) {
        usuarioRepository.deleteById(id);
    }
}
