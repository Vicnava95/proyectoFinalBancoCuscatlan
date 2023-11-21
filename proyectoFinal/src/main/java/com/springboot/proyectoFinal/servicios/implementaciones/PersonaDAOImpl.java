package com.springboot.proyectoFinal.servicios.implementaciones;

import com.springboot.proyectoFinal.models.entity.Persona;
import com.springboot.proyectoFinal.repositorios.PersonaRepository;
import com.springboot.proyectoFinal.servicios.contratos.PersonaDAO;

import java.util.Optional;

public class PersonaDAOImpl extends GenericDAOImpl<Persona, PersonaRepository> implements PersonaDAO {
    public PersonaDAOImpl(PersonaRepository repository) {
        super(repository);
    }

    @Override
    public Optional<Persona> buscarPorNombre(String nombre) {
        return repository.buscarPorNombre(nombre);
    }

    @Override
    public Optional<Persona> buscarPorApellido(String apellido) {
        return repository.buscarPorApellido(apellido);
    }

    @Override
    public Optional<Persona> buscarPorEmail(String email) {
        return repository.buscarPorEmail(email);
    }
}
