package com.springboot.proyectoFinal.controller;

import com.springboot.proyectoFinal.exception.BadRequestException;
import com.springboot.proyectoFinal.models.entity.Factura;
import com.springboot.proyectoFinal.servicios.contratos.FacturaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/facturas")
public class FacturaController {
    private final FacturaDAO facturaDAO;

    @Autowired
    public FacturaController(FacturaDAO facturaDAO) {
        this.facturaDAO = facturaDAO;
    }

    @GetMapping("/listar")
    public List<Factura> listarFacturas(){
        List<Factura> facturas = (List<Factura>) facturaDAO.findAll();
        if (facturas.isEmpty()){
            throw new BadRequestException("No existen facturas");
        }
        return facturas;
    }
}
