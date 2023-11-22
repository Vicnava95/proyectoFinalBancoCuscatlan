package com.springboot.proyectoFinal.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.springboot.proyectoFinal.models.entity.Categoria;
import com.springboot.proyectoFinal.repositorios.CategoriaRepository;

@RestController
@RequestMapping("/categoria")
public class CategoriaControler {
	
	@Autowired
	CategoriaRepository categoriaDAO;
	
	@GetMapping(value = "/listar", produces = "application/json")
	public Iterable<Categoria> listar()
	{
		
		return categoriaDAO.findAll();
	}
	
	/*
	@GetMapping(value = "/nuevoNombres", produces = "application/json")
	public String pornombre(@RequestParam("nombre") String nombre)
	{
		
		Gson json = new Gson();
		
		Categoria  cat= new Categoria(); 
		cat.setNombre(nombre);
		categoriaDAO.save(cat);
		
		
		return json.toJson(categoriaDAO.findAll()); 
		
		//return json.toJson(nombre);
	}
*/

	
	
	@PostMapping(value = "/nuevoNombre")
	Categoria   pornombrePost(@RequestParam("nombre") String nombre)
	{
		
		Gson json = new Gson();
		Categoria  cat= new Categoria(); 
		cat.setNombre(nombre);
		return categoriaDAO.save(cat);	
	}
	
	
	

}
