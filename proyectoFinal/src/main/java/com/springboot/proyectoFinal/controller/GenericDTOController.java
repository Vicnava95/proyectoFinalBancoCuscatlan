package com.springboot.proyectoFinal.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.Binding;

import lombok.NoArgsConstructor;
import org.springframework.validation.BindingResult;

import com.springboot.proyectoFinal.servicios.contratos.GenericDAO;

import lombok.AllArgsConstructor;



public class GenericDTOController <E,S extends GenericDAO<E>>{
	
	protected final S service;
	protected final String nombre_entidad;

	public GenericDTOController(S service, String nombre_entidad) {
		this.service = service;
		this.nombre_entidad = nombre_entidad;
	}

	public List<E> obtenerTodos()
	{
		return (List<E>) service.findAll();
	};
	
	public E obtenerporId(Long id)
	{
		return (E) service.findById(id);
	};
	
	public E altaEntidad(E entidad) 
	{
		return service.save(entidad);
	};
	
	protected Map<String, Object> obtenerValidaciones(BindingResult result)
	{
		Map<String, Object> validaciones = new HashMap<>();
		result.getFieldErrors()
		.forEach(error ->validaciones.put(error.getField(), error.getDefaultMessage()));
		return validaciones;
		
	}

}
