package com.springboot.proyectoFinal.controller.dto;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.springboot.proyectoFinal.models.dto.UsuarioDTO;
import com.springboot.proyectoFinal.models.entity.Persona;
import com.springboot.proyectoFinal.models.entity.Usuario;
import com.springboot.proyectoFinal.models.mapper.mapstruct.PersonaMapper;
import com.springboot.proyectoFinal.servicios.contratos.UsuarioDAO;

@RestController
@RequestMapping("/usuarioDTO")
public class UsuarioDtoController {
	
	
	@Autowired
	UsuarioDAO usuarioDAO;
	
	
	@GetMapping("/listar")
	public List<UsuarioDTO> listarUsuarios()
	{
		Iterable<Persona> iterable = usuarioDAO.findAll();
		
		List<Persona> usuarios = new ArrayList<>();
		iterable.forEach(usuarios::add);
		
		return usuarios.stream().map( user -> PersonaMapper.mapper.mapUsuario((Usuario) user))
				.collect(Collectors.toList());
	}

	@GetMapping("/{id}")
	public UsuarioDTO obtenerporId(Long id)
	{
		Optional<Persona> person =  usuarioDAO.findById(id);

		Persona persona= person.get();

		return PersonaMapper.mapper.mapUsuario((Usuario) persona);
	}



}
