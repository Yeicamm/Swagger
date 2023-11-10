package com.electiva2.grupo3.DTO;


import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UsuarioRespondeDto {


    private String documento;
    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    private Boolean estado;


}




