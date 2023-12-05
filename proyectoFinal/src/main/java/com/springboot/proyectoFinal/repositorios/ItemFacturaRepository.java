package com.springboot.proyectoFinal.repositorios;

import com.springboot.proyectoFinal.models.entity.Factura;
import com.springboot.proyectoFinal.models.entity.ItemFactura;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ItemFacturaRepository extends CrudRepository<ItemFactura,Long> {

    @Query("select i from ItemFactura i where i.producto = ?1")
    Optional<Factura> buscarPorIdProducto(Long id);
}
