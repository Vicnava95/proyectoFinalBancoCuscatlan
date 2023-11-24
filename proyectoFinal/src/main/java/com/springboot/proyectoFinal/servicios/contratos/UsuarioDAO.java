package com.springboot.proyectoFinal.servicios.contratos;

import com.springboot.proyectoFinal.models.entity.Persona;
import com.springboot.proyectoFinal.models.entity.Usuario;

import java.util.Optional;

public interface UsuarioDAO extends PersonaDAO{
    Optional<Usuario> buscarUsuarioPorUsername(String username);
    
    Optional<Usuario> FindByIdd(Long id);
    
}
