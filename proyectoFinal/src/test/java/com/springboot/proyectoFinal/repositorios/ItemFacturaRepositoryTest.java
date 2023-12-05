package com.springboot.proyectoFinal.repositorios;

import com.springboot.proyectoFinal.datos.DatosDummy;
import com.springboot.proyectoFinal.models.entity.Categoria;
import com.springboot.proyectoFinal.models.entity.ItemFactura;
import com.springboot.proyectoFinal.models.entity.Producto;
import com.springboot.proyectoFinal.models.entity.Proveedor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class ItemFacturaRepositoryTest {

    @Autowired
    ProductoRepository productoRepository;

    @Autowired
    ItemFacturaRepository itemFacturaRepository;

    @BeforeEach
    void setUp() {
        Categoria categoria = DatosDummy.categoria01();
        Proveedor proveedor = DatosDummy.proveedor01();
        Producto producto = DatosDummy.producto01();
        producto.setCategoria(categoria);
        producto.setProveedor(proveedor);
        productoRepository.save(producto);

        ItemFactura itemFactura = DatosDummy.itemFactura1();
        itemFactura.setProducto(producto);
        itemFactura.setCantidad(5);
        itemFacturaRepository.save(itemFactura);
    }

    @Test
    void buscarPorIdProducto() {
    }
}