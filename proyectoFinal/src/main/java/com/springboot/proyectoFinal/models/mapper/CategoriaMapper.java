package com.springboot.proyectoFinal.models.mapper;

import com.springboot.proyectoFinal.models.dto.CategoriaDTO;
import com.springboot.proyectoFinal.models.entity.Categoria;

public class CategoriaMapper {

	public static CategoriaDTO mapCategoria(Categoria categoria) 
	{
		CategoriaDTO dto = new CategoriaDTO();
		
		dto.setNombre(categoria.getNombre());
		return dto;
	};
}
