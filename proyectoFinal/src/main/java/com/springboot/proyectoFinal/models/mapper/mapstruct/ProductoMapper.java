package com.springboot.proyectoFinal.models.mapper.mapstruct;

import com.springboot.proyectoFinal.models.dto.ProductoDTO;
import com.springboot.proyectoFinal.models.entity.Producto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductoMapper {

    ProductoMapper mapper = Mappers.getMapper(ProductoMapper.class);

    ProductoDTO mapProducto(Producto producto);
}
