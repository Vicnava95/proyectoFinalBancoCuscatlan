package com.springboot.proyectoFinal.servicios.implementaciones;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.springboot.proyectoFinal.models.entity.Proveedor;
import com.springboot.proyectoFinal.repositorios.ProveedorRepository;
import com.springboot.proyectoFinal.servicios.contratos.GenericDAO;
import com.springboot.proyectoFinal.servicios.contratos.ProveedorDAO;

public class ProveedorDAOImpl extends GenericDAOImpl<Proveedor, ProveedorRepository> implements ProveedorDAO{

	public ProveedorDAOImpl(ProveedorRepository repository) {
		super(repository);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Optional<Proveedor> buscarPorNombre(String nombre) {
		
		
		
		return repository.buscarPorNombre(nombre);
	}

	@Override
	public Optional<Proveedor> buscarPorDireccion(String direccion) {
		// TODO Auto-generated method stub
		return repository.buscarPorDireccion(direccion);
	}
	
	
	

	
	
	

}
