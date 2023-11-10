package com.electiva2.grupo3.servicio.impl;

import com.electiva2.grupo3.DTO.LoginDto;
import com.electiva2.grupo3.DTO.UsuarioLoginDto;
import com.electiva2.grupo3.DTO.UsuarioRespondeDto;
import com.electiva2.grupo3.entity.Persona;
import com.electiva2.grupo3.entity.Usuario;
import com.electiva2.grupo3.repository.PersonaRepository;
import com.electiva2.grupo3.repository.UsuarioRepository;
import com.electiva2.grupo3.servicio.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.DocFlavor;
import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public Object login(LoginDto loginDto) {
        if ((loginDto.getUserCorreo() == null) || loginDto.getUserCorreo().isEmpty()){
            return "No se envio el correo ";
        }
        Usuario usuario = usuarioRepository.findByCorreo(loginDto.getUserCorreo());


        String password = loginDto.getPassword();
        String bdContra = usuario.getContraseña();
        Boolean estado = usuario.getEstado();


        if ((loginDto.getPassword() == null) || loginDto.getPassword().isEmpty()){
            return "No se envio la contraseña";
        }

        if ((bdContra.equals(password)) ){
            if (estado){
                Optional<Persona> persona = personaRepository.findById(usuario.getPersona().getId());
                if (persona.isPresent()){
                    UsuarioRespondeDto usuarioRespondeDto = UsuarioRespondeDto
                            .builder()
                            .correo(usuario.getCorreo())
                            .estado(usuario.getEstado())
                            .documento(persona.get().getDocumento())
                            .nombre(persona.get().getNombre())
                            .apellido(persona.get().getApellido())
                            .telefono(persona.get().getTelefono())
                            .build();

                    return UsuarioLoginDto
                            .builder()
                            .usuario(usuarioRespondeDto)
                            .autoriacion(true)
                            .build();
                }else {
                    return "No se encontro una persona asociada al usuario "+usuario.getCorreo();
                }
            }else {
                return "la cuenta se encuentra deshabilitada";
            }

        } else {
            return "Credenciales invalidas";
        }

    }

    @Override
    public String actualizarContraseña(LoginDto loginDto) {
        Usuario usuario = usuarioRepository.findByCorreo(loginDto.getUserCorreo());

        if (usuario != null){
            usuario.setContraseña(loginDto.getPassword());
            usuarioRepository.save(usuario);
            return "se actualizo correctamente la contraseña";
        }
        return "No se logro actualizar la contraseña ";
    }
}
