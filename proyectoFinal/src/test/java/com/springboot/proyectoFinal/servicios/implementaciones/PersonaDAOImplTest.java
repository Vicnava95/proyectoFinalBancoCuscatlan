package com.springboot.proyectoFinal.servicios.implementaciones;

import com.springboot.proyectoFinal.datos.DatosDummy;
import com.springboot.proyectoFinal.models.entity.Persona;
import com.springboot.proyectoFinal.repositorios.PersonaRepository;
import com.springboot.proyectoFinal.servicios.contratos.PersonaDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PersonaDAOImplTest {

    PersonaDAO personaDAO;
    PersonaRepository personaRepository;

    @BeforeEach
    void setUp() {
        personaRepository = mock(PersonaRepository.class);
        personaDAO = new PersonaDAOImpl(personaRepository);
    }

    @Test
    void buscarPorNombre() {
        String nombre = "Víctor";
        when(personaRepository.buscarPorNombre(nombre)).thenReturn(Optional.of(DatosDummy.persona1()));

        Optional<Persona> expected = personaDAO.buscarPorNombre(nombre);

        assertThat(expected.get().getNombre()).isEqualTo(DatosDummy.persona1().getNombre());
        verify(personaRepository).buscarPorNombre(nombre);
    }

    @Test
    void buscarPorApellido() {
        String apellido = "Navarrete";
        when(personaRepository.buscarPorApellido(apellido)).thenReturn(Optional.of(DatosDummy.persona1()));

        Optional<Persona> expected = personaDAO.buscarPorApellido(apellido);

        assertThat(expected.get().getApellido()).isEqualTo(DatosDummy.persona1().getApellido());
        verify(personaRepository).buscarPorApellido(apellido);
    }

    @Test
    void buscarPorEmail() {
        String email = "dr2495@gmail.com";
        when(personaRepository.buscarPorEmail(email)).thenReturn(Optional.of(DatosDummy.persona2()));

        Optional<Persona> expected = personaDAO.buscarPorEmail(email);

        assertThat(expected.get().getEmail()).isEqualTo(DatosDummy.persona2().getEmail());
        verify(personaRepository).buscarPorEmail(email);
    }
}