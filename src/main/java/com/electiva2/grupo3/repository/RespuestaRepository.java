package com.electiva2.grupo3.repository;

import com.electiva2.grupo3.entity.Respuesta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface RespuestaRepository extends JpaRepository<Respuesta, Long> {

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO Respuesta (descripcion, id_usuario, id_solicitud) VALUES (:descripcion, :id_usuario, :id_solicitud)",nativeQuery = true)
    void insertarRespuestaConQuery(@Param("descripcion") String descripcion, @Param("id_usuario") Long id_usuario, @Param("id_solicitud") Long id_solicitud);
}
