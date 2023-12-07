package com.springboot.proyectoFinal.controller;

import com.springboot.proyectoFinal.exception.BadRequestException;
import com.springboot.proyectoFinal.servicios.contratos.GenericDAO;
import jakarta.validation.Valid;
import org.springframework.data.repository.cdi.Eager;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.*;

public class GenericController<E, S extends GenericDAO<E>> {
    protected final S service;
    protected String nombreEntidad;

    public GenericController(S service) {
        this.service = service;
    }

    @GetMapping("/listar")
    public ResponseEntity<?> obetenerTodos(){
        Map<String, Object> mensaje = new HashMap<>();
        List<E> listado = (List<E>) service.findAll();
        if (listado.isEmpty()){
            /*throw new BadRequestException(String.format("No se han encontrado %ss",nombreEntidad));*/
            mensaje.put("success",Boolean.FALSE);
            mensaje.put("mensaje",String.format("No se han encontrado %ss",nombreEntidad));
            return ResponseEntity.badRequest().body(mensaje);
        }

        mensaje.put("success",Boolean.TRUE);
        mensaje.put("datos",listado);
        return ResponseEntity.ok(mensaje);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerPorId(@PathVariable Long id){
        Map<String, Object> mensaje = new HashMap<>();
        Optional<E> e = service.findById(id);
        if (!e.isPresent()){
            /*throw new BadRequestException(String.format("El id de %s no se ha encontrado",nombreEntidad));*/
            mensaje.put("success",Boolean.FALSE);
            mensaje.put("mensaje",String.format("El id de %s no se ha encontrado",nombreEntidad));
            return ResponseEntity.badRequest().body(mensaje);
        }
        mensaje.put("success",Boolean.TRUE);
        mensaje.put("datos",e);
        return ResponseEntity.ok(mensaje);
    }

    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody E e, BindingResult result){
        //Validaciones
        Map<String, Object> validaciones = new HashMap<>();
        if (result.hasErrors()){
            result.getFieldErrors()
                    .forEach(error ->validaciones.put(error.getField(), error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(validaciones);
        }

        Map<String, Object> mensaje = new HashMap<>();
        mensaje.put("success",Boolean.TRUE);
        mensaje.put("datos",service.save(e));
        return ResponseEntity.ok(mensaje);
    }

    @DeleteMapping(value = "/{id}")
    public void eliminar(@PathVariable Long id){
        service.deleteById(id);
    }
}
