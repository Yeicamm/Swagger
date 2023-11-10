package com.electiva2.grupo3.controller;

import com.electiva2.grupo3.DTO.LoginDto;
import com.electiva2.grupo3.servicio.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping()
    public Object login(@RequestBody LoginDto loginDto){
        return loginService.login(loginDto);
    }

    @PatchMapping("/cambiarContraseña")
    public String actualizarContraseña(@RequestBody LoginDto loginDto){
        return loginService.actualizarContraseña(loginDto);
    }


}
