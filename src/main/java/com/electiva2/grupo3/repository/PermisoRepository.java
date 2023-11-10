package com.electiva2.grupo3.repository;

import com.electiva2.grupo3.entity.Permiso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermisoRepository extends JpaRepository<Permiso, Long> {
    // You can add custom queries if needed
}
