package com.springboot.proyectoFinal.controller.dto;

import com.springboot.proyectoFinal.exception.BadRequestException;
import com.springboot.proyectoFinal.models.dto.ProductoDTO;
import com.springboot.proyectoFinal.models.entity.Producto;
import com.springboot.proyectoFinal.models.mapper.mapstruct.ProductoMapper;
import com.springboot.proyectoFinal.servicios.contratos.ProductoDAO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;
@Deprecated
@RestController
@RequestMapping("/productoDTO")
public class ProductoDtoController {

    @Autowired
    ProductoDAO productoDAO;


    @GetMapping("/listar")
    public List<ProductoDTO> listarProductos()
    {
        Iterable<Producto> iterable = productoDAO.findAll();

        List<Producto> productos = new ArrayList<>();
        iterable.forEach(productos::add );

        return  productos.stream().map(products -> ProductoMapper.mapper.mapProducto((Producto) products)).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ProductoDTO obtenerporId(@PathVariable Long id)
    {
        Optional<Producto> product = productoDAO.findById(id);

        Producto  producto = product.get();

        return ProductoMapper.mapper.mapProducto(producto);
    }

    @PostMapping("/nuevoProducto")
    public ResponseEntity<?> nuevoProducto(@Valid @RequestBody Producto producto, BindingResult result)
    {
        Map<String, Object> validaciones = new HashMap<>();
        if (result.hasErrors()){
            result.getFieldErrors()
                    .forEach(error ->validaciones.put(error.getField(), error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(validaciones);
        }

        Map<String, Object> mensaje = new HashMap<>();

        mensaje.put("Success", Boolean.TRUE);
        Producto producto1 = productoDAO.save(producto);
        mensaje.put("Data", ProductoMapper.mapper.mapProducto(producto1));

        return ResponseEntity.ok(mensaje);
    }

    @PutMapping("/{id}")
    public ProductoDTO actualizarProducto(@PathVariable Long id,@RequestBody Producto producto)
    {
        Producto product = null;
        Optional<Producto> producto0 = productoDAO.findById(id);
        if(!producto0.isPresent())
        {
            throw  new BadRequestException("El id del producto no existe");

        }
        product = producto0.get();
        product.setNombre(producto.getNombre());
        product.setCategoria(producto.getCategoria());
        product.setDescripcion(producto.getDescripcion());
        product.setPrecio(producto.getPrecio());
        product.setCreateAt(producto.getCreateAt());
        product.setProveedor(producto.getProveedor());
        product.setStock(producto.getStock());

        productoDAO.save(product);

        return ProductoMapper.mapper.mapProducto(product);
    }

    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable Long id)
    {
        productoDAO.deleteById(id);
    }
}
