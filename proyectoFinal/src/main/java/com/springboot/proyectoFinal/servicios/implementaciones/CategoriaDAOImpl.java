package com.springboot.proyectoFinal.servicios.implementaciones;

import java.util.Optional;

import com.springboot.proyectoFinal.models.entity.Categoria;
import com.springboot.proyectoFinal.repositorios.CategoriaRepository;
import com.springboot.proyectoFinal.servicios.contratos.CategoriaDAO;

public class CategoriaDAOImpl extends GenericDAOImpl<Categoria, CategoriaRepository> implements CategoriaDAO {

	public CategoriaDAOImpl(CategoriaRepository repository) {
		super(repository);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Optional<Categoria> buscarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return repository.buscarPorNombre(nombre);
	}
	
	

}
