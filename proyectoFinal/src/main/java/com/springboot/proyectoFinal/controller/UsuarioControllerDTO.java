package com.springboot.proyectoFinal.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.proyectoFinal.models.dto.PersonaDTO;
import com.springboot.proyectoFinal.models.entity.Persona;
import com.springboot.proyectoFinal.models.entity.Usuario;
import com.springboot.proyectoFinal.models.mapper.UsuarioMapper;
import com.springboot.proyectoFinal.servicios.contratos.PersonaDAO;

@RestController
@RequestMapping("/dto")
public class UsuarioControllerDTO {

	@Autowired
	private PersonaDAO personaDAO;
	
	@Autowired
	private UsuarioMapper mapper;
	
	@GetMapping("/{id}")
	public ResponseEntity<?> obtenerporId(@PathVariable Long id)
	{
		Map<String, Object> mensaje = new HashMap<>();
		Optional<Persona> oPersona = personaDAO.findById(id);
		
		PersonaDTO dto = mapper.mapUsuario((Usuario) oPersona.get());
		
		mensaje.put("data", dto);
		
		return ResponseEntity.ok(mensaje);
		
	}
}
