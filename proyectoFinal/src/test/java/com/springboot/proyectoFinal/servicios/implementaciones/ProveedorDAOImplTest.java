package com.springboot.proyectoFinal.servicios.implementaciones;

import com.springboot.proyectoFinal.datos.DatosDummy;
import com.springboot.proyectoFinal.models.entity.Proveedor;
import com.springboot.proyectoFinal.repositorios.ProveedorRepository;
import com.springboot.proyectoFinal.servicios.contratos.ProveedorDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProveedorDAOImplTest {

    ProveedorDAO proveedorDAO;
    ProveedorRepository proveedorRepository;

    @BeforeEach
    void setUp() {
        proveedorRepository = mock(ProveedorRepository.class);
        proveedorDAO = new ProveedorDAOImpl(proveedorRepository);
    }

    @Test
    void buscarPorNombre() {
        //Given
        String nombre = "Intel";
        when(proveedorRepository.buscarPorNombre(nombre)).thenReturn(Optional.of(DatosDummy.proveedor01()));

        //When
        Optional<Proveedor> expected = proveedorDAO.buscarPorNombre(nombre);

        //Then
        assertThat(expected.get().getNombre()).isEqualTo(DatosDummy.proveedor01().getNombre());
        verify(proveedorRepository).buscarPorNombre(nombre);
    }

    @Test
    void buscarPorDireccion() {
        //Given
        String direccion = "Metrocentro";
        when(proveedorRepository.buscarPorDireccion(direccion)).thenReturn(Optional.of(DatosDummy.proveedor01()));

        //When
        Optional<Proveedor> expected = proveedorDAO.buscarPorDireccion(direccion);

        //Then
        assertThat(expected.get().getDireccion()).isEqualTo(DatosDummy.proveedor01().getDireccion());
        verify(proveedorRepository).buscarPorDireccion(direccion);
    }
}