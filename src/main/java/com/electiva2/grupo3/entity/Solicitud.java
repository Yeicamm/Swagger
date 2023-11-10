package com.electiva2.grupo3.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.transaction.annotation.Transactional;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "solicitud")
public class Solicitud {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "tipo_peticion", nullable = false)
    private String tipoPeticion;
    @Column(name = "peticion", nullable = false)
    private String peticion;
    @Column(name = "estado", nullable = false)
    private Boolean estado;
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

}
