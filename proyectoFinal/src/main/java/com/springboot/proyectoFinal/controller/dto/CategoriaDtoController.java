package com.springboot.proyectoFinal.controller.dto;

import com.springboot.proyectoFinal.models.dto.CategoriaDTO;
import com.springboot.proyectoFinal.models.entity.Categoria;
import com.springboot.proyectoFinal.models.mapper.CategoriaMapper;
import com.springboot.proyectoFinal.servicios.contratos.CategoriaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categoria")
public class CategoriaDtoController {

    @Autowired
    private CategoriaDAO categoriaDAO;
    @GetMapping("/listar")
    public ResponseEntity<?> obtenerTodos(){
        Map<String, Object> mensaje = new HashMap<>();
        List<Categoria> categorias = (List<Categoria>) categoriaDAO.findAll();

        List<CategoriaDTO> categoriasDtos = categorias
                .stream()
                .map(CategoriaMapper::mapCategoria)
                .collect(Collectors.toList());

        mensaje.put("success",Boolean.TRUE);
        mensaje.put("datos",categoriasDtos);

        return ResponseEntity.ok(mensaje);
    }
}
