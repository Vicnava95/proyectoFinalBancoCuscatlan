package com.springboot.proyectoFinal.controller;

import java.util.List;
import java.util.Optional;

import com.springboot.proyectoFinal.exception.BadRequestException;
import com.springboot.proyectoFinal.models.entity.Categoria;
import com.springboot.proyectoFinal.servicios.contratos.UsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.springboot.proyectoFinal.models.entity.Persona;
import com.springboot.proyectoFinal.models.entity.Usuario;
import com.springboot.proyectoFinal.models.entity.enumeradores.TipoUsuario;
import com.springboot.proyectoFinal.repositorios.PersonaRepository;
import com.springboot.proyectoFinal.repositorios.UsuarioRepository;


@RestController
@RequestMapping("/usuario")
public class UsuarioController{

	private final UsuarioDAO usuarioDAO;

	@Autowired
	public UsuarioController(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	@GetMapping(value = "/listar")
	public List<Persona> listarUsuarios(){
		List<Persona> usuarios = (List<Persona>) usuarioDAO.findAll();
		if (usuarios.isEmpty()){
			throw new BadRequestException("No existen usuarios");
		}
		return usuarios;
	}
	@GetMapping("/{id}")
	public Persona obtenerPorId(@PathVariable Long id){
		Optional<Persona> persona = usuarioDAO.findById(id);
		if (!persona.isPresent()){
			throw new BadRequestException("El id de la persona no existe");
		}
		return persona.get();
	}
	@PostMapping
	public Usuario crearPersona(@RequestBody Usuario persona){
		return (Usuario) usuarioDAO.save(persona);
	}

	@PutMapping("/{id}")
	public Usuario actualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario){
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

		return (Usuario) usuarioDAO.save(usuarioUpdate);
	}

	@DeleteMapping(value = "/{id}")
	public void eliminarUsuario(@PathVariable Long id){
        usuarioDAO.deleteById(id);
    }
	//David
	/*@Autowired
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
	}*/
	
}
