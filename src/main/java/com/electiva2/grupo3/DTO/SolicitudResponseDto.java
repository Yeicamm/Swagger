package com.electiva2.grupo3.DTO;


import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class SolicitudResponseDto {

    private Long id;
    private String tipoPeticion;
    private String peticion;
    private Boolean estado;
}
