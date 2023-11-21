package com.springboot.proyectoFinal.repositorios;

import com.springboot.proyectoFinal.models.entity.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository("repositorioUsuario")
public interface UsuarioRepository extends PersonaRepository{
    @Query("select u from Usuario u where u.username = ?1")
    Optional<Persona> buscarUsuarioPorUsername(String username);
}
