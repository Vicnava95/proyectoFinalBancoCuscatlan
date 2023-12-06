package com.springboot.proyectoFinal.controller;

import com.springboot.proyectoFinal.exception.BadRequestException;
import com.springboot.proyectoFinal.servicios.contratos.GenericDAO;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class GenericController<E, S extends GenericDAO<E>> {
    protected final S service;
    protected String nombreEntidad;

    public GenericController(S service) {
        this.service = service;
    }

    @GetMapping("/listar")
    public List<E> obetenerTodos(){
        List<E> listado = (List<E>) service.findAll();
        if (listado.isEmpty()){
            throw new BadRequestException(String.format("No se han encontrado %ss",nombreEntidad));
        }
        return listado;
    }
}
