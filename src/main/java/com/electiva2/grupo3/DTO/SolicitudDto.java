package com.electiva2.grupo3.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SolicitudDto {

    private String tipoPeticion;
    private String peticion;
    private Boolean estado;
    private Long usuario;

}
