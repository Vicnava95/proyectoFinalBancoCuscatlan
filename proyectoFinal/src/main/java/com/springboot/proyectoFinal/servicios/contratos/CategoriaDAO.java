package com.springboot.proyectoFinal.servicios.contratos;

import java.util.List;
import java.util.Optional;

import com.springboot.proyectoFinal.models.entity.Categoria;

public interface CategoriaDAO extends GenericDAO<Categoria> {
	
	Optional<Categoria> buscarPorNombre(String nombre);

}
