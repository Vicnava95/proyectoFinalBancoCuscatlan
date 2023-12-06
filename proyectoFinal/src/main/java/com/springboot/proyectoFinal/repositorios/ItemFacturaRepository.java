package com.springboot.proyectoFinal.repositorios;

import com.springboot.proyectoFinal.models.entity.Factura;
import com.springboot.proyectoFinal.models.entity.ItemFactura;
import com.springboot.proyectoFinal.models.entity.Persona;
import com.springboot.proyectoFinal.models.entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ItemFacturaRepository extends CrudRepository<ItemFactura,Long> {

    @Query("select i from ItemFactura i where i.producto.id = ?1")
    Optional<ItemFactura> buscarPorIdProducto(Long id);
}
