package com.springboot.proyectoFinal.controller.dto;

import com.springboot.proyectoFinal.servicios.contratos.GenericDAO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


public class GenericDtoController<E, S extends GenericDAO<E>>{
    protected final S service;
    protected final String nombreEntidad;

    public GenericDtoController(S service, String nombreEntidad) {
        this.service = service;
        this.nombreEntidad = nombreEntidad;
    }

    public List<E> obtenerTodos(){
        return (List<E>) service.findAll();
    }
    public Optional<E> buscarPorId(Long id){
        return service.findById(id);
    }

    public E crearEntidad(E entidad){
        return service.save(entidad);
    }
    public void eliminarPorId(Long id){
        service.deleteById(id);
    }

    protected Map<String, Object> obtenerValidaciones(BindingResult result){
        Map<String, Object> validaciones = new HashMap<>();
        result.getFieldErrors()
                .forEach(error ->validaciones.put(error.getField(), error.getDefaultMessage()));
        return validaciones;
    }

}
