package com.springboot.proyectoFinal.servicios.contratos;

import com.springboot.proyectoFinal.models.entity.Factura;
import com.springboot.proyectoFinal.models.entity.ItemFactura;

import java.util.Optional;

public interface ItemFacturaDAO extends GenericDAO<ItemFactura>{
    Optional<Factura> buscarPorIdProducto(Long id);
}
