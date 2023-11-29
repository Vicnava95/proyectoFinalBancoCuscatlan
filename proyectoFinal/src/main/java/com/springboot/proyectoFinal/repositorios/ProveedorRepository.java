package com.springboot.proyectoFinal.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.springboot.proyectoFinal.models.entity.Proveedor;

public interface ProveedorRepository extends CrudRepository<Proveedor, Long>{
	
    @Query("select p from Proveedor p where p.nombre = ?1")
    Optional<Proveedor> buscarPorNombre(String nombre);
    @Query("select p from Proveedor p where p.direccion = ?1")
    Optional<Proveedor> buscarPorDireccion(String direccion);
}
