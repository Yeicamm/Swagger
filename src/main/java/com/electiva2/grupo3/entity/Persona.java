package com.electiva2.grupo3.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "persona")
public class Persona {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "documento", unique = true, nullable = false)
    private String documento;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "apellido", nullable = false)
    private String apellido;
    @Column(name = "correo", unique = true, nullable = false)
    private String correo;
    @Column(name = "telefono", unique = true, nullable = false)
    private String telefono;

}
