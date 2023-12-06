package com.springboot.proyectoFinal.repositorios;

import com.springboot.proyectoFinal.datos.DatosDummy;
import com.springboot.proyectoFinal.models.entity.Categoria;
import com.springboot.proyectoFinal.models.entity.ItemFactura;
import com.springboot.proyectoFinal.models.entity.Producto;
import com.springboot.proyectoFinal.models.entity.Proveedor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

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
        DatosDummy.producto01().setProveedor(proveedor);
        DatosDummy.producto01().setCategoria(categoria);
        productoRepository.save(DatosDummy.producto01());

        DatosDummy.itemFactura1().setCantidad(5);
        DatosDummy.itemFactura1().setProducto(DatosDummy.producto01());
        itemFacturaRepository.save(DatosDummy.itemFactura1());
    }

    @AfterEach
    void tearDown() {
        productoRepository.deleteAll();
        itemFacturaRepository.deleteAll();
    }

    @Test
    void buscarPorIdProducto() {
        Producto producto = productoRepository.findById(1L).orElse(null); // Obtener el producto por su ID
        Optional<ItemFactura> expected = itemFacturaRepository.buscarPorIdProducto(producto.getId());
    }
}