package com.springboot.proyectoFinal.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.proyectoFinal.models.entity.Persona;
import com.springboot.proyectoFinal.models.entity.Usuario;
import com.springboot.proyectoFinal.models.entity.enumeradores.TipoUsuario;
import com.springboot.proyectoFinal.repositorios.PersonaRepository;
import com.springboot.proyectoFinal.repositorios.UsuarioRepository;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioDAO;
	
	@GetMapping(value = "/listar", produces = "application/json")
	public Iterable<Persona> ListarUsuarios()
	{
		
		return usuarioDAO.findAll();
	}
	
	@DeleteMapping(value = "/eliminar", produces = "application/json")
	public void eliminarUsuario(@RequestParam("id") Long id)
	{
		usuarioDAO.deleteById(id);
		
	}
	
	
	
	@PutMapping(value = "/actualizar", produces = "application/json")
	public Usuario actualizarUsuario(@RequestParam("nombre") String nombre, @RequestParam("apellido") String apellido,
			@RequestParam("email")String email, @RequestParam("username") String username, @RequestParam("id") Long id)
	{
		
		
		
		Optional<Usuario> persona = usuarioDAO.findByIdd(id);
		
		Usuario usuario = persona.get();
		
		usuario.setNombre(nombre);
		usuario.setApellido(apellido);
		usuario.setEmail(email);
		usuario.setUsername(username);
		
		
		return usuarioDAO.save(usuario);
	}
	
	
	
	@GetMapping(value = "/porId", produces ="application/json")
	public Optional<Usuario> porId(@RequestParam("id") Long id)
	{
		return usuarioDAO.findByIdd(id);	
	}
	
	@PostMapping(value = "nuevoUsuario", produces = "application/json")
	public Usuario nuevoUsuario(@RequestParam("nombre") String nombre, @RequestParam("apellido") String apellido, 
			@RequestParam("email") String email, @RequestParam("password") String  pass, @RequestParam("username") String username,
			@RequestParam("tipo_Usuario") String tUsuario)
	{
		
		Usuario usuario = new Usuario();
		
		usuario.setNombre(nombre);
		usuario.setApellido(apellido);
		usuario.setEmail(email);
		usuario.setContrasenia(pass);
		usuario.setUsername(username);
		
		if(tUsuario.equals( "PREMIUM") || tUsuario.equals( "premium") || tUsuario.equals( "Premium")  )
		{
			usuario.setTipoUsuario(TipoUsuario.PREMIUM);
		}
		else if(tUsuario.equals( "GOLD") || tUsuario.equals( "gold") || tUsuario.equals( "Gold"))
		{
			usuario.setTipoUsuario(TipoUsuario.GOLD);
		}
		else if(tUsuario.equals( "SILVER") || tUsuario.equals( "silver") || tUsuario.equals( "Silver"))
		{
			usuario.setTipoUsuario(TipoUsuario.SILVER);
		}
		else if(tUsuario.equals( "BRONZE") || tUsuario.equals( "bronze") || tUsuario.equals( "Bronze"))
		{
			usuario.setTipoUsuario(TipoUsuario.SILVER);
		}
		
		
		return usuarioDAO.save(usuario);
	}
	
}
