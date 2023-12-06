package com.springboot.proyectoFinal.controller;

import com.springboot.proyectoFinal.exception.BadRequestException;
import com.springboot.proyectoFinal.models.entity.Categoria;
import com.springboot.proyectoFinal.servicios.contratos.CategoriaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaControler {

	private final CategoriaDAO categoriaDAO;

	@Autowired
	public CategoriaControler(CategoriaDAO categoriaDAO) {
		this.categoriaDAO = categoriaDAO;
	}

	@GetMapping(value = "/listar")
	public List<Categoria> listar()
	{
		List<Categoria> categorias = (List<Categoria>) categoriaDAO.findAll();
		if(categorias.isEmpty()){
			throw new BadRequestException("No existen categorias");
		}
		return categorias;
	}

	//DAVID
	/*@Autowired
	CategoriaRepository categoriaDAO;
	
	@GetMapping(value = "/listar", produces = "application/json")
	public Iterable<Categoria> listar()
	{
		
		return categoriaDAO.findAll();
	}
	
	
	
	@PostMapping(value = "/nuevoNombre")
	Categoria   nuevoNombre(@RequestParam("nombre") String nombre)
	{
		
		
		Categoria  cat= new Categoria(); 
		cat.setNombre(nombre);
		return categoriaDAO.save(cat);	
	}
	
	@GetMapping(value = "/byNombre", produces = "application/json" )
	public Iterable<Categoria> byNombre( @RequestParam("nombre") String nombre)
	{
		return categoriaDAO.buscarPorNombre(nombre);
	}
	
	@DeleteMapping(value = "/eliminar", produces = "application/json")
	public void eliminarCategoria(@RequestParam("id") Long id)
	{
		
		categoriaDAO.deleteById(id);
	}
	
	@PutMapping(value = "/actualizar", produces ="application/json")
	public Categoria actualizarCategoria(@RequestParam("nombre") String nombre, @RequestParam("id") Long id)
	{
		Optional<Categoria> cat = categoriaDAO.findById(id);
		
		Categoria categoria = cat.get();
		
		categoria.setNombre(nombre);
		
		return categoriaDAO.save(categoria);
	}*/
	

}
