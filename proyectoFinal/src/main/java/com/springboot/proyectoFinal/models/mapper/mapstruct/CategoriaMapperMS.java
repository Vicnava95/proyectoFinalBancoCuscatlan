package com.springboot.proyectoFinal.models.mapper.mapstruct;

import com.springboot.proyectoFinal.models.dto.categoriaDTO;
import com.springboot.proyectoFinal.models.entity.Categoria;
import com.springboot.proyectoFinal.servicios.contratos.CategoriaDAO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoriaMapperMS {

    @Mappings(
            @Mapping(source = "nombre", target = "categoria")

    )
    categoriaDTO mapCategoria(Categoria categoria);
}
