package com.springboot.proyectoFinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.springboot.proyectoFinal.repositorios.ProveedorRepository;

@RestController
@RequestMapping("/proveedor")
public class ProveedorController {

	@Autowired
	ProveedorRepository proveedorDAO;

	@GetMapping(value = "/listar", produces = "application/json")
	public String listar()
	{
		Gson json = new Gson();
		return json.toJson(proveedorDAO.findAll());
	}
	
	

}
