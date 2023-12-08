package com.springboot.proyectoFinal.controller.dto;

import com.springboot.proyectoFinal.exception.BadRequestException;
import com.springboot.proyectoFinal.models.dto.CategoriaDTO;
import com.springboot.proyectoFinal.models.entity.Categoria;
import com.springboot.proyectoFinal.models.mapper.CategoriaMapper;
import com.springboot.proyectoFinal.servicios.contratos.CategoriaDAO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categoria")
public class CategoriaDtoController extends GenericDtoController<Categoria,CategoriaDAO>{

    @Autowired
    private CategoriaMapper mapper;

    public CategoriaDtoController(CategoriaDAO service) {
        super(service, "Categoria");
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listar(){
        Map<String, Object> mensaje = new HashMap<>();
        List<Categoria> categorias =  super.obtenerTodos();

        if (categorias.isEmpty()){
            mensaje.put("success",Boolean.FALSE);
            mensaje.put("datos",categorias);
            return ResponseEntity.badRequest().body(mensaje);
        }

        List<CategoriaDTO> categoriasDtos = categorias
                .stream()
                .map(CategoriaMapper::mapCategoria)
                .collect(Collectors.toList());

        mensaje.put("success",Boolean.TRUE);
        mensaje.put("datos",categoriasDtos);

        return ResponseEntity.ok(mensaje);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerPorId(@PathVariable Long id){
        Map<String, Object> mensaje = new HashMap<>();

        Optional<Categoria> optionalCategoria = super.buscarPorId(id);
        Categoria categoria = optionalCategoria.orElse(null);
        if (categoria == null){
            /*throw new BadRequestException(String.format("El id de %s no se ha encontrado",nombreEntidad));*/
            mensaje.put("success",Boolean.FALSE);
            mensaje.put("mensaje",String.format("El id de %s no se ha encontrado",nombreEntidad));
            return ResponseEntity.badRequest().body(mensaje);
        }

        CategoriaDTO categoriasDtos = CategoriaMapper.mapCategoria(categoria);
        mensaje.put("success",Boolean.TRUE);
        mensaje.put("datos",categoriasDtos);

        return ResponseEntity.ok(mensaje);
    }

    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody Categoria categoria, BindingResult result){
        //Validaciones
        super.obtenerValidaciones(result);
        super.crearEntidad(categoria);
        Map<String, Object> mensaje = new HashMap<>();

        CategoriaDTO categoriasDtos = CategoriaMapper.mapCategoria(categoria);
        mensaje.put("success",Boolean.TRUE);
        mensaje.put("datos",categoriasDtos);
        return ResponseEntity.ok(mensaje);
    }

    @DeleteMapping(value = "/{id}")
    public void eliminar(@PathVariable Long id){
        super.eliminarPorId(id);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id,@Valid @RequestBody Categoria categoria, BindingResult result){
        Map<String, Object> mensaje = new HashMap<>();
        Optional<Categoria> optionalCategoria = super.buscarPorId(id);
        Categoria categoria2 = optionalCategoria.orElse(null);
        if (categoria == null){
            /*throw new BadRequestException(String.format("El id de %s no se ha encontrado",nombreEntidad));*/
            mensaje.put("success",Boolean.FALSE);
            mensaje.put("mensaje",String.format("El id de %s no se ha encontrado",nombreEntidad));
            return ResponseEntity.badRequest().body(mensaje);
        }
        categoria2.setNombre(categoria.getNombre());
        service.save(categoria2);

        CategoriaDTO categoriasDtos = CategoriaMapper.mapCategoria(categoria2);
        mensaje.put("success",Boolean.TRUE);
        mensaje.put("datos",categoriasDtos);

        return ResponseEntity.ok(mensaje);
    }


}
