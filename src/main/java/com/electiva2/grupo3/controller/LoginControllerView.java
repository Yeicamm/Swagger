package com.electiva2.grupo3.controller;

import com.electiva2.grupo3.DTO.LoginDto;
import com.electiva2.grupo3.entity.Usuario;
import com.electiva2.grupo3.repository.UsuarioRepository;
import com.electiva2.grupo3.servicio.LoginService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginControllerView {

    private final LoginService loginService;

    private final UsuarioRepository usuarioRepository;

    public LoginControllerView(LoginService loginService, UsuarioRepository usuarioRepository) {
        this.loginService = loginService;
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping("/log")
    public String showLoginForm(Model model) {
        model.addAttribute("loginDto", new LoginDto());
        return "login";
    }

    @PostMapping("/request")
    public String login(@RequestParam("email") String email, @RequestParam("password") String password) {


        Usuario usuario = usuarioRepository.findByCorreo(email);
        System.out.println(email + " correo pasando");

        if (usuario != null) {
            if (usuario.getContraseña().equals(password)) {
                // Autenticación exitosa
                // Puedes redirigir a la página principal o realizar otras acciones necesarias
                return "requestRegistration";
            } else {
                // Credenciales inválidas
                return "login";
            }

        } else{
            return "login";
        }
    }

    @GetMapping("/forgotPass")
    public String Forgot(Model model) {
        model.addAttribute("loginDto", new LoginDto());
        return "forgot";
    }

    @GetMapping("/CreateAcc")
    public String CreateAcc(Model model) {
        model.addAttribute("loginDto", new LoginDto());
        return "singUp";
    }
}
