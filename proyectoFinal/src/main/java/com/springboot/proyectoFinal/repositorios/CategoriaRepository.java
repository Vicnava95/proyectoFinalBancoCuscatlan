package com.springboot.proyectoFinal.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.springboot.proyectoFinal.models.entity.Categoria;


public interface CategoriaRepository extends CrudRepository<Categoria, Long>{
	
	 //Acá se pueden realizar consultas específicas
    @Query("select c from Categoria c where c.nombre = ?1")
    Optional<Categoria> buscarPorNombre(String nombre);
    

}
