package com.electiva2.grupo3.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "rol")
public class Rol {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "estado", nullable = false)
    private Boolean estado;
    @Column(name = "descripcion", nullable = false)
    private String descripcion;
    @ManyToMany(mappedBy = "roles")
    private Set<Usuario> usuarios;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "rol_permiso",
            joinColumns = @JoinColumn(name = "id_rol"),
            inverseJoinColumns = @JoinColumn(name = "id_permiso"))
    private Set<Permiso> permisos;

    public static final String ADMIN = "ROLE_ADMIN";
    public static final String CLIENTE = "ROLE_CLIENTE";
    public static final String ASESOR = "ROLE_ASESOR";



}
