package com.springboot.proyectoFinal.repositorios;

import com.springboot.proyectoFinal.models.entity.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface PersonaRepository extends CrudRepository<Persona, Long> {
    //Acá se pueden realizar consultas específicas
    @Query("select p from Persona p where p.nombre = ?1")
    Optional<Persona> buscarPorNombre(String nombre);
    @Query("select p from Persona p where p.apellido = ?1")
    Optional<Persona> buscarPorApellido(String apellido);
    @Query("select p from Persona p where p.email like %?1%")
    Optional<Persona> buscarPorEmail(String email);
}
