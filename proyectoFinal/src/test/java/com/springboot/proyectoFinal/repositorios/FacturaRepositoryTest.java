package com.springboot.proyectoFinal.repositorios;

import com.springboot.proyectoFinal.datos.DatosDummy;
import com.springboot.proyectoFinal.models.entity.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class FacturaRepositoryTest {
    @Autowired
    ProductoRepository productoRepository;
    @Autowired
    ItemFacturaRepository itemFacturaRepository;
    @Autowired
    CategoriaRepository categoriaRepository;
    @Autowired
    ProveedorRepository proveedorRepository;
    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    FacturaRepository facturaRepository;
    @BeforeEach
    void setUp() {
        Categoria categoria = DatosDummy.categoria01();
        Proveedor proveedor = DatosDummy.proveedor01();
        DatosDummy.producto01().setProveedor(proveedor);
        DatosDummy.producto01().setCategoria(categoria);
        categoriaRepository.save(DatosDummy.categoria01());
        proveedorRepository.save(DatosDummy.proveedor01());

        DatosDummy.itemFactura1().setCantidad(5);
        DatosDummy.itemFactura1().setProducto(DatosDummy.producto01());
        productoRepository.save(DatosDummy.producto01());
        itemFacturaRepository.save(DatosDummy.itemFactura1());

        /*personaRepository.save(DatosDummy.persona1());
        Optional<Persona> persona = personaRepository.findById(1L);*/

        facturaRepository.save(DatosDummy.factura());
    }

    @Test
    void buscarPorUsuarioId() {
        usuarioRepository.save(DatosDummy.persona1());
        Optional<Persona> persona = usuarioRepository.findById(1L);
        //System.out.println(persona.get().getNombre());

        Optional<Factura> factura = facturaRepository.findById(1L);
        factura.get().setUsuario(persona.get());
        factura.get().setNotas("Primera factura");

        Optional<Factura> expected = facturaRepository.buscarPorUsuarioId(persona.get().getId());
        assertThat(expected.get().getUsuario().getId()).isEqualTo(persona.get().getId());
    }
}