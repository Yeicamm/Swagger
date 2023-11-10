package com.electiva2.grupo3.repository;

import com.electiva2.grupo3.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {

    Optional<Rol> findByDescripcion(String descripcion);
}
