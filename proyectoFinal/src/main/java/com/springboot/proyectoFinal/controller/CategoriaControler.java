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
public class CategoriaControler extends GenericController<Categoria, CategoriaDAO>{


	@Autowired
	public CategoriaControler(CategoriaDAO service) {
		super(service);
		nombreEntidad = "Categoria";
	}



	@GetMapping("/{id}")
	public Categoria obtenerPorId(@PathVariable Long id){
		Optional<Categoria> categoria = service.findById(id);
		if (!categoria.isPresent()){
			throw new BadRequestException("El id de la carrera no existe");
		}
		return categoria.get();
	}

	@PostMapping
	public Categoria crearCategoria(@RequestBody Categoria categoria){
		return service.save(categoria);
	}
}
