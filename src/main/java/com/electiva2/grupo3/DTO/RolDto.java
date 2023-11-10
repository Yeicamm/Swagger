package com.electiva2.grupo3.DTO;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class RolDto {
    private Boolean estado;
    private String descripcion;
}
