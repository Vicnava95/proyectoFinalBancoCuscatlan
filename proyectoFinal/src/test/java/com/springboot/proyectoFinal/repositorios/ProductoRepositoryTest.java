package com.springboot.proyectoFinal.repositorios;

import com.springboot.proyectoFinal.datos.DatosDummy;
import com.springboot.proyectoFinal.models.entity.Producto;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class ProductoRepositoryTest {

    @Autowired
    ProductoRepository productoRepository;

    @Autowired
    CategoriaRepository categoriaRepository;
    @Autowired
    ProveedorRepository proveedorRepository;

    @BeforeEach
    void setUp() {
        categoriaRepository.save(DatosDummy.categoria01());
        categoriaRepository.save(DatosDummy.categoria02());
        proveedorRepository.save(DatosDummy.proveedor01());
        proveedorRepository.save(DatosDummy.proveedor02());
        DatosDummy.producto01().setProveedor(DatosDummy.proveedor01());
        DatosDummy.producto01().setCategoria(DatosDummy.categoria01());
        productoRepository.save(DatosDummy.producto01());
    }

    @AfterEach
    void tearDown() {
        categoriaRepository.deleteAll();
        proveedorRepository.deleteAll();
        productoRepository.deleteAll();
    }

    @Test
    void buscarProductoPorNombre() {
        //Nombre a buscar
        String nombre = "NVidea4090";

        //Producto ingresado
        Optional<Producto> expected = productoRepository.buscarProductoPorNombre(DatosDummy.producto01().getNombre());

        //Validación
        assertThat(expected.get().getNombre()).isEqualTo(nombre);
    }
}