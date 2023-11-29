package com.springboot.proyectoFinal.servicios.implementaciones;

import com.springboot.proyectoFinal.datos.DatosDummy;
import com.springboot.proyectoFinal.models.entity.Producto;
import com.springboot.proyectoFinal.repositorios.ProductoRepository;
import com.springboot.proyectoFinal.servicios.contratos.ProductoDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductoDAOImplTest {
    ProductoDAO productoDAO;
    ProductoRepository productoRepository;
    @BeforeEach
    void setUp() {
        productoRepository = mock(ProductoRepository.class);
        productoDAO = new ProductoDAOImpl(productoRepository);
    }
    @Test
    void buscarProductoPorNombre() {
        String nombre = "NVidea4090";
        when(productoRepository.buscarProductoPorNombre(nombre)).thenReturn(Optional.of(DatosDummy.producto01()));

        Optional<Producto> expected = productoDAO.buscarProductoPorNombre(nombre);

        assertThat(expected.get().getNombre()).isEqualTo(DatosDummy.producto01().getNombre());
        verify(productoRepository).buscarProductoPorNombre(nombre);
    }
}