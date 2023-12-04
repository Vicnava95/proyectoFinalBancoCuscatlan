package com.springboot.proyectoFinal.repositorios;

import com.springboot.proyectoFinal.datos.DatosDummy;
import com.springboot.proyectoFinal.models.entity.Persona;
import com.springboot.proyectoFinal.models.entity.Usuario;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class UsuarioRepositoryTest {

    @Autowired
    @Qualifier("repositorioUsuario")
    PersonaRepository personaRepository;

    @BeforeEach
    void setUp() {
        personaRepository.save(DatosDummy.persona1());
        personaRepository.save(DatosDummy.persona2());
    }

    @AfterEach
    void tearDown() {
        personaRepository.deleteAll();
    }

    @Test
    void buscarUsuarioPorUsername() {
        String username = "vicnava95";
        Optional<Usuario> expected = ((UsuarioRepository)personaRepository).buscarUsuarioPorUsername(username);
        assertThat(expected.get().getUsername()).isEqualTo(username);
    }

}