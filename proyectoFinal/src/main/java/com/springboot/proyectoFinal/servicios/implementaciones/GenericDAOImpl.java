package com.springboot.proyectoFinal.servicios.implementaciones;

import com.springboot.proyectoFinal.servicios.contratos.GenericDAO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public class GenericDAOImpl<E, R extends CrudRepository<E, Long>> implements GenericDAO<E> {
    protected final R repository;

    public GenericDAOImpl(R repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<E> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public E save(E e) {
        return repository.save(e);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<E> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
