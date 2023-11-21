package com.springboot.proyectoFinal.servicios.contratos;

import java.util.Optional;

public interface GenericDAO<T> {
    Optional<T> findById(Long id);
    T save(T t);
    Iterable<T> findAll();
    void deleteById(Long id);
}
