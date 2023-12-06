package com.springboot.proyectoFinal.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.springboot.proyectoFinal.models.mapper.mapstruct.CategoriaMapperMS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.proyectoFinal.models.dto.CategoriaDTO;
import com.springboot.proyectoFinal.models.entity.Categoria;
import com.springboot.proyectoFinal.models.mapper.CategoriaMapper;
import com.springboot.proyectoFinal.servicios.contratos.CategoriaDAO;

@RestController
@RequestMapping("/categoriaDTO")
public class CategoriaDTOController {

	
	@Autowired
	CategoriaDAO categoriaDAO;
	@Autowired
	CategoriaMapperMS mapper;
	
	@GetMapping(value = "/listar")
	public ResponseEntity<?> listarCategorias()
	{
		Map<String, Object> mensaje = new HashMap<>();
		List<Categoria> categoria = (List<Categoria>) categoriaDAO.findAll();
		
		List<CategoriaDTO> categoriaDTO = categoria.stream().map(mapper::mapCategoria).collect(Collectors.toList());
		
		mensaje.put("success",Boolean.TRUE);
		mensaje.put("data", categoriaDTO);
		
		return ResponseEntity.ok(mensaje);
		
	}	
}
