package com.springboot.proyectoFinal.servicios.contratos;

import com.springboot.proyectoFinal.models.entity.Factura;
import com.springboot.proyectoFinal.models.entity.ItemFactura;
import com.springboot.proyectoFinal.models.entity.Producto;

import java.util.Optional;

public interface ItemFacturaDAO extends GenericDAO<ItemFactura>{
    Optional<ItemFactura> buscarPorIdProducto(Long id);
}
