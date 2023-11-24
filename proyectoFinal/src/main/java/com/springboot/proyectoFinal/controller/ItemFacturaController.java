package com.springboot.proyectoFinal.controller;

import com.google.gson.Gson;
import com.springboot.proyectoFinal.models.entity.ItemFactura;
import com.springboot.proyectoFinal.repositorios.ItemFacturaRepository;
import com.springboot.proyectoFinal.servicios.contratos.ItemFacturaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/itemsFactura")
public class ItemFacturaController {

    @Autowired
    ItemFacturaRepository itemFacturaDAO;

    @GetMapping(value = "/listar", produces = "application/json")
    public Iterable<ItemFactura> listar(){
        return itemFacturaDAO.findAll();
    }
}
