package com.springboot.proyectoFinal.repositorios;

import com.springboot.proyectoFinal.datos.DatosDummy;
import com.springboot.proyectoFinal.models.entity.Persona;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class PersonaRepositoryTest {
    @Autowired
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
    void buscarPorNombre() {
        String nombre = "Víctor";
        Optional<Persona> expected = personaRepository.buscarPorNombre(DatosDummy.persona1().getNombre());

        assertThat(expected.get().getNombre()).isEqualTo(nombre);
    }

    @Test
    void buscarPorApellido() {
        String apellido = "Ramos";
        Optional<Persona> expected = personaRepository.buscarPorApellido(DatosDummy.persona2().getApellido());

        assertThat(expected.get().getApellido()).isEqualTo(apellido);
    }

    @Test
    void buscarPorEmail() {
        String email = "dr2495@gmail.com";
        Optional<Persona> expected = personaRepository.buscarPorEmail(DatosDummy.persona2().getEmail());

        assertThat(expected.get().getEmail()).isEqualTo(email);
    }
}