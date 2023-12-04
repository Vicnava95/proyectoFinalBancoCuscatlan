package com.springboot.proyectoFinal.servicios.contratos;

import com.springboot.proyectoFinal.models.entity.Factura;

import java.util.Optional;

public interface FacturaDAO extends GenericDAO<Factura>{
    Optional<Factura> buscarPorUsuarioID(Long id);
}
