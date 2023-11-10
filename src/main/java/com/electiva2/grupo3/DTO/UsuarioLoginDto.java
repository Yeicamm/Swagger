package com.electiva2.grupo3.DTO;

import com.electiva2.grupo3.entity.Usuario;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UsuarioLoginDto {

    private UsuarioRespondeDto usuario;
    private Boolean autoriacion;
}
