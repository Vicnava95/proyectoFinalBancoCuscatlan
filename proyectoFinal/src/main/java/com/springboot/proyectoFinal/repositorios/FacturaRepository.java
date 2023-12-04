package com.springboot.proyectoFinal.repositorios;

import com.springboot.proyectoFinal.models.entity.Factura;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;


public interface FacturaRepository extends CrudRepository<Factura,Long> {

    @Query("select f from Factura f where f.usuario_id = ?1")
    Optional<Factura> buscarPorUsuarioID(Long id);
}
