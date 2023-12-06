package com.springboot.proyectoFinal.controller;

import com.springboot.proyectoFinal.exception.BadRequestException;
import com.springboot.proyectoFinal.models.entity.Categoria;
import com.springboot.proyectoFinal.servicios.contratos.CategoriaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

	@GetMapping("/{id}")
	public Categoria obtenerPorId(@PathVariable Long id){
		Optional<Categoria> categoria = categoriaDAO.findById(id);
		if (!categoria.isPresent()){
			throw new BadRequestException("El id de la carrera no existe");
		}
		return categoria.get();
	}

	@PostMapping
	public Categoria crearCategoria(@RequestBody Categoria categoria){
		return categoriaDAO.save(categoria);
	}
}
