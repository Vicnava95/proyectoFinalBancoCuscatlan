package com.springboot.proyectoFinal.repositorios;

import com.springboot.proyectoFinal.models.entity.Persona;
import com.springboot.proyectoFinal.models.entity.Usuario;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository("repositorioUsuario")
public interface UsuarioRepository extends PersonaRepository{
    @Query("select u from Usuario u where u.username = ?1")
    Optional<Usuario> buscarUsuarioPorUsername(String username);
    
    @Query("select u from Usuario u where u.id = ?1")
    Optional<Usuario> findByIdd(Long id);
}
