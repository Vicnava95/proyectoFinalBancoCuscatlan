package com.springboot.proyectoFinal.servicios.implementaciones;

import com.springboot.proyectoFinal.datos.DatosDummy;
import com.springboot.proyectoFinal.models.entity.Factura;
import com.springboot.proyectoFinal.repositorios.FacturaRepository;
import com.springboot.proyectoFinal.servicios.contratos.FacturaDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FacturaDAOImplTest {
    FacturaDAO facturaDAO;
    FacturaRepository facturaRepository;

    @BeforeEach
    void setUp() {
        facturaRepository = mock(FacturaRepository.class);
        facturaDAO = new FacturaDAOImpl(facturaRepository);
    }

    @Test
    void buscarPorUsuarioId() {
        Long id = 1L;
        when(facturaRepository.buscarPorUsuarioId(id)).thenReturn(Optional.of(DatosDummy.factura()));

        Optional<Factura> expected = Optional.ofNullable(facturaDAO.buscarPorUsuarioId(id).orElse(null));

        verify(facturaRepository).buscarPorUsuarioId(id);
    }
}