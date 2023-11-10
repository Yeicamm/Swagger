package com.electiva2.grupo3.DTO;

import com.electiva2.grupo3.entity.Rol;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class UsuarioDTO {
    private String correo;
    private String contraseña;
    private Long idPersona;
    private List<Rol> roles;

}
