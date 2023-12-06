package com.springboot.proyectoFinal.servicios.implementaciones;

import com.springboot.proyectoFinal.datos.DatosDummy;
import com.springboot.proyectoFinal.models.entity.ItemFactura;
import com.springboot.proyectoFinal.repositorios.ItemFacturaRepository;
import com.springboot.proyectoFinal.servicios.contratos.ItemFacturaDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ItemFacturaDAOImplTest {
    ItemFacturaDAO itemFacturaDAO;
    ItemFacturaRepository itemFacturaRepository;

    @BeforeEach
    void setUp() {
        itemFacturaRepository = mock(ItemFacturaRepository.class);
        itemFacturaDAO = new ItemFacturaDAOImpl(itemFacturaRepository);
    }

    @Test
    void buscarPorIdProducto() {
        Long id = 1L;
        when(itemFacturaRepository.buscarPorIdProducto(id)).thenReturn(Optional.of(DatosDummy.itemFactura1()));

        Optional<ItemFactura> expected = Optional.ofNullable(itemFacturaDAO.buscarPorIdProducto(id).orElse(null));

        verify(itemFacturaRepository).buscarPorIdProducto(id);

    }
}