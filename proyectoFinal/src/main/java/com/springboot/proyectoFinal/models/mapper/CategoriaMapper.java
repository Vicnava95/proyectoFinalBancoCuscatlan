package com.springboot.proyectoFinal.models.mapper;

import com.springboot.proyectoFinal.models.dto.categoriaDTO;
import com.springboot.proyectoFinal.models.entity.Categoria;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CategoriaMapper {

    public static categoriaDTO convertirDTO(Categoria categoria)
    {
        categoriaDTO cat = new categoriaDTO();

        cat.setCategoria(categoria.getNombre());



        return cat;
    }
}
