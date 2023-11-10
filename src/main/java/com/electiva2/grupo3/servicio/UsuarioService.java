package com.electiva2.grupo3.servicio;

import com.electiva2.grupo3.entity.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    Optional<Usuario> getByIdUser(Long id);
    List<Usuario> getAllUsers();
    Usuario createUser(Usuario usuario);
    void deleteUser(Long id);
}
