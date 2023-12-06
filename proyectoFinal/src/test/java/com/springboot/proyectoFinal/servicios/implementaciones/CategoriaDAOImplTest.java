package com.springboot.proyectoFinal.servicios.implementaciones;

import com.springboot.proyectoFinal.datos.DatosDummy;
import com.springboot.proyectoFinal.models.entity.Categoria;
import com.springboot.proyectoFinal.repositorios.CategoriaRepository;
import com.springboot.proyectoFinal.servicios.contratos.CategoriaDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CategoriaDAOImplTest {
    CategoriaDAO categoriaDAO;
    CategoriaRepository categoriaRepository;

    @BeforeEach
    void setUp() {
        categoriaRepository = mock(CategoriaRepository.class);
        categoriaDAO = new CategoriaDAOImpl(categoriaRepository);
    }

    @Test
    void buscarPorNombre() {
        String palabra = "Televisores";
        when(categoriaRepository.buscarPorNombre(palabra))
                .thenReturn(Arrays.asList(DatosDummy.categoria01(),DatosDummy.categoria02()));

        List<Categoria> expected =(List<Categoria>)categoriaDAO.buscarPorNombre(palabra);

        assertThat(expected.get(0).getNombre()).isEqualTo(DatosDummy.categoria01().getNombre());
        assertThat(expected.get(1).getNombre()).isEqualTo(DatosDummy.categoria02().getNombre());

        verify(categoriaRepository).buscarPorNombre(palabra);


    }
}