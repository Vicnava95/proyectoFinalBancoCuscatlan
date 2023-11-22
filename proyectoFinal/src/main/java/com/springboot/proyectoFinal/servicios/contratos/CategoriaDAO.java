package com.springboot.proyectoFinal.servicios.contratos;

import java.util.List;
import java.util.Optional;

import com.springboot.proyectoFinal.models.entity.Categoria;

public interface CategoriaDAO extends GenericDAO<Categoria> {
	
	Iterable<Categoria> buscarPorNombre(String nombre);
	

}
