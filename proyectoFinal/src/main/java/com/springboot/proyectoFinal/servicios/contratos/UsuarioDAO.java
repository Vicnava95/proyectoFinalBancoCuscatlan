package com.springboot.proyectoFinal.servicios.contratos;

import com.springboot.proyectoFinal.models.entity.Persona;

import java.util.Optional;

public interface UsuarioDAO extends PersonaDAO{
    Optional<Persona> buscarUsuarioPorUsername(String username);
}
