package com.springboot.proyectoFinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.springboot.proyectoFinal.repositorios.CategoriaRepository;

@RestController
@RequestMapping("/categoria")
public class CategoriaControler {
	
	@Autowired
	CategoriaRepository categoriaDAO;
	
	@GetMapping(value = "/listar", produces = "application/json")
	public String listar()
	{
		Gson json = new Gson();
		
		return json.toJson(categoriaDAO.findAll());
		
	}
	
	

}
