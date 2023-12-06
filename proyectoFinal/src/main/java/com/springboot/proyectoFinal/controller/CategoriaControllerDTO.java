package com.springboot.proyectoFinal.controller;

import com.springboot.proyectoFinal.models.dto.categoriaDTO;
import com.springboot.proyectoFinal.models.entity.Categoria;
import com.springboot.proyectoFinal.models.mapper.CategoriaMapper;
import com.springboot.proyectoFinal.servicios.contratos.CategoriaDAO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.Option;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categoriaDTO")
public class CategoriaControllerDTO {


    @Autowired
    CategoriaDAO categoriaDAO;

    @Autowired
    CategoriaMapper mapper;

    @GetMapping("/listar")
    public ResponseEntity<?> listarCategorias()
    {
        Map<String, Object> mensaje = new HashMap<>();
        List<Categoria> cat = (List<Categoria>) categoriaDAO.findAll();

        List<categoriaDTO> categoria = cat.stream().map(CategoriaMapper::convertirDTO).collect(Collectors.toList());

        mensaje.put("data", categoria);
        return ResponseEntity.ok(mensaje);
    }

}
