package com.springboot.proyectoFinal.repositorios;

import com.springboot.proyectoFinal.datos.DatosDummy;
import com.springboot.proyectoFinal.models.entity.Proveedor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class ProveedorRepositoryTest {

    @Autowired
    ProveedorRepository proveedorRepository;
    @BeforeEach
    void setUp() {
        proveedorRepository.save(DatosDummy.proveedor01());
        proveedorRepository.save(DatosDummy.proveedor02());
    }

    @AfterEach
    void tearDown() {
        proveedorRepository.deleteAll();
    }

    @Test
    void buscarPorNombre() {
        String palabra = "Intel";
        Optional<Proveedor> expected = proveedorRepository.buscarPorNombre(DatosDummy.proveedor01().getNombre());
        assertThat(expected.get().getNombre()).isEqualTo(palabra);
    }

    @Test
    void buscarPorDireccion() {
        String direccion = "Metrocentro";
        Optional<Proveedor> expected = proveedorRepository.buscarPorDireccion(DatosDummy.proveedor02().getDireccion());
        assertThat(expected.get().getDireccion()).isEqualTo(direccion);
    }
}