package com.electiva2.grupo3.DTO;

import lombok.Getter;

@Getter
public class SolicitudDto {

    private String tipoPeticion;
    private String peticion;
    private Boolean estado;
    private Long usuario;

}
