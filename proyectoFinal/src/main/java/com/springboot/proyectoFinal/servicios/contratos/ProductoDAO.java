package com.springboot.proyectoFinal.servicios.contratos;

import com.springboot.proyectoFinal.models.entity.Producto;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProductoDAO extends GenericDAO<Producto>{
    Optional<Producto> buscarProductoPorNombre(String nombre);
}
