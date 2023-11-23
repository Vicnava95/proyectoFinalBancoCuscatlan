package com.springboot.proyectoFinal.repositorios;

import com.springboot.proyectoFinal.models.entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProductoRepository extends CrudRepository<Producto, Long> {
    @Query("select p from Producto p where p.nombre = ?1")
    Optional<Producto> buscarProductoPorNombre(String nombre);
}
