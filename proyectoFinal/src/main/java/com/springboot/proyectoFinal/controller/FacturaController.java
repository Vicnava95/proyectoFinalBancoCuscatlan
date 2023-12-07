package com.springboot.proyectoFinal.controller;

import com.springboot.proyectoFinal.exception.BadRequestException;
import com.springboot.proyectoFinal.models.entity.Factura;
import com.springboot.proyectoFinal.servicios.contratos.FacturaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/facturas")
public class FacturaController{
    private final FacturaDAO facturaDAO;

    public FacturaController(FacturaDAO facturaDAO) {
        this.facturaDAO = facturaDAO;
    }

    @GetMapping(value = "/listar")
    public List<Factura> listarFacturas(){
        List<Factura> facturas = (List<Factura>) facturaDAO.findAll();
        if (facturas.isEmpty()){
            throw new BadRequestException("No existen facturas");
        }
        return facturas;
    }
    @GetMapping("/{id}")
    public Factura obtenerPorId(@PathVariable Long id){
        Optional<Factura> factura = facturaDAO.findById(id);
        if (!factura.isPresent()){
            throw new BadRequestException("El id de la factura no existe");
        }
        return factura.get();
    }
    @PostMapping
    public Factura crearFactura(@RequestBody Factura factura){
        return facturaDAO.save(factura);
    }

    @DeleteMapping(value = "/{id}")
    public void eliminarFactura(@PathVariable Long id){
        facturaDAO.deleteById(id);
    }
}
