package com.springboot.proyectoFinal.repositorios;

import com.springboot.proyectoFinal.datos.DatosDummy;
import com.springboot.proyectoFinal.models.entity.Categoria;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class CategoriaRepositoryTest {

    @Autowired
    CategoriaRepository categoriaRepository;
    @BeforeEach
    void setUp() {
        categoriaRepository.save(DatosDummy.categoria01());
        categoriaRepository.save(DatosDummy.categoria02());
    }
    @AfterEach
    void tearDown() {
        categoriaRepository.deleteAll();
    }
    @Test
    void buscarPorNombre() {
        String palabra = "Televisores";
        Iterable<Categoria> expected = categoriaRepository.buscarPorNombre(DatosDummy.categoria01().getNombre());
        assertThat(((List<?>) expected).size() == 1 ).isTrue();
    }
}