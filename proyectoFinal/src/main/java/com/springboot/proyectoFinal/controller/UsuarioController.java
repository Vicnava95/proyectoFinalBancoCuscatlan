package com.springboot.proyectoFinal.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.proyectoFinal.models.entity.Persona;
import com.springboot.proyectoFinal.repositorios.PersonaRepository;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private PersonaRepository usuarioDAO;
	
	@GetMapping(value = "/listar", produces = "application/json")
	public Iterable<Persona> ListarUsuarios()
	{
		
		return usuarioDAO.findAll();
	}

}
