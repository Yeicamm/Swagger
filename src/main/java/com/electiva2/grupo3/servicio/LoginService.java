package com.electiva2.grupo3.servicio;

import com.electiva2.grupo3.DTO.LoginDto;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface LoginService {

    Object login(LoginDto loginDto);
    String actualizarContraseña(LoginDto loginDto);
}
