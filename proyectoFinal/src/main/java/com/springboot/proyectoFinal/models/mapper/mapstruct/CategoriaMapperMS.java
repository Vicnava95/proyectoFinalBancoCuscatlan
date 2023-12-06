package com.springboot.proyectoFinal.models.mapper.mapstruct;

import com.springboot.proyectoFinal.models.dto.CategoriaDTO;
import com.springboot.proyectoFinal.models.entity.Categoria;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel ="spring")
public interface CategoriaMapperMS {


    CategoriaDTO mapCategoria(Categoria categoria);
}
