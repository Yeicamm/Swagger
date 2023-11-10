package com.electiva2.grupo3.repository;

import com.electiva2.grupo3.entity.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface SolicitudRepository extends JpaRepository<Solicitud, Long> {
    // You can add custom queries if needed

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO Solicitud (tipo_peticion, peticion, estado, id_usuario) VALUES (:tipoPeticion, :peticion, :estado, :usuario)",nativeQuery = true)
    void insertarSolicitudConQuery(@Param("tipoPeticion") String tipoPeticion, @Param("peticion") String peticion, @Param("estado") Boolean estado, @Param("usuario") Long usuario);
}
