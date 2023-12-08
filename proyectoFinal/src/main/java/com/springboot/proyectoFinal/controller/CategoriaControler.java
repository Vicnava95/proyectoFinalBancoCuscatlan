package com.springboot.proyectoFinal.controller;

import com.springboot.proyectoFinal.exception.BadRequestException;
import com.springboot.proyectoFinal.models.entity.Categoria;
import com.springboot.proyectoFinal.servicios.contratos.CategoriaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Deprecated
@RestController
@RequestMapping("/categoria")
@ConditionalOnProperty(name = "controller.enable-dto", havingValue = "false")
public class CategoriaControler extends GenericController<Categoria, CategoriaDAO>{
	@Autowired
	public CategoriaControler(CategoriaDAO service) {
		super(service);
		nombreEntidad = "Categoria";
	}
}
