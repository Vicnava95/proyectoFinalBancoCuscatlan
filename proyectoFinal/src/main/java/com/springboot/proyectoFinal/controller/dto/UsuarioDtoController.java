package com.springboot.proyectoFinal.controller.dto;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.springboot.proyectoFinal.exception.BadRequestException;
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

	@PostMapping("/nuevoUsuario")
	public ResponseEntity<?> nuevoUsuario(@Valid @RequestBody Usuario persona, BindingResult result)
	{

		Map<String, Object> validaciones = new HashMap<>();
		if (result.hasErrors()){
			result.getFieldErrors()
					.forEach(error ->validaciones.put(error.getField(), error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(validaciones);
		}

		Map<String, Object> mensaje = new HashMap<>();
		mensaje.put("success",Boolean.TRUE);
		Usuario user=(Usuario) usuarioDAO.save(persona);
		mensaje.put("datos",PersonaMapper.mapper.mapUsuario(user) );
		return ResponseEntity.ok(mensaje);
	}

	@PutMapping("/{id}")
	public UsuarioDTO actualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario){
		Usuario usuarioUpdate = null;
		Optional<Persona> usuarioO = usuarioDAO.findById(id);
		if (!usuarioO.isPresent()){
			throw new BadRequestException("El id del usuario no existe");
		}
		usuarioUpdate = (Usuario) usuarioO.get();
		usuarioUpdate.setNombre(usuario.getNombre());
		usuarioUpdate.setTipoUsuario(usuario.getTipoUsuario());
		usuarioUpdate.setUsername(usuario.getUsername());
		usuarioUpdate.setApellido(usuario.getApellido());

		 usuarioDAO.save(usuarioUpdate);

		return PersonaMapper.mapper.mapUsuario(usuarioUpdate);

	}

	@DeleteMapping("/{id}")
	public void eliminarUsuario(@PathVariable Long id)
	{
		usuarioDAO.deleteById(id);

	}



}
