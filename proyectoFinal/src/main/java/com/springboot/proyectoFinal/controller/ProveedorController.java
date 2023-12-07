package com.springboot.proyectoFinal.controller;

import java.util.List;
import java.util.Optional;

import com.springboot.proyectoFinal.exception.BadRequestException;
import com.springboot.proyectoFinal.models.entity.Producto;
import com.springboot.proyectoFinal.servicios.contratos.ProveedorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.introspect.AccessorNamingStrategy.Provider;
import com.google.gson.Gson;
import com.springboot.proyectoFinal.models.entity.Proveedor;
import com.springboot.proyectoFinal.repositorios.ProveedorRepository;

@RestController
@RequestMapping("/proveedor")
public class ProveedorController extends GenericController<Proveedor, ProveedorDAO>{

    @Autowired
    public ProveedorController(ProveedorDAO service) {
        super(service);
    }
}
