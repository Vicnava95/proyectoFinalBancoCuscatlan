package com.springboot.proyectoFinal.servicios.contratos;

import com.springboot.proyectoFinal.models.entity.Persona;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PersonaDAO extends GenericDAO<Persona>{
    Optional<Persona> buscarPorNombre(String nombre);
    Optional<Persona> buscarPorApellido(String apellido);
    Optional<Persona> buscarPorEmail(String email);

}
