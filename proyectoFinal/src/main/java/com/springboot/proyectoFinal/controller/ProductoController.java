package com.springboot.proyectoFinal.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.proyectoFinal.models.entity.Categoria;
import com.springboot.proyectoFinal.models.entity.Producto;
import com.springboot.proyectoFinal.models.entity.Proveedor;
import com.springboot.proyectoFinal.repositorios.ProductoRepository;

@RestController
@RequestMapping("/producto")
public class ProductoController {
	
	@Autowired
	ProductoRepository productoDAO;
	
	@GetMapping(value ="/listar", produces ="application/json")
	public Iterable<Producto> listarProductos()
	{
		return productoDAO.findAll();	
	}

	
	@GetMapping(value = "/porId" , produces = "application/json")
	public Optional<Producto> buscarProducto(@RequestParam("id") Long id)
	{
		
		return productoDAO.findById(id);
	}
	
	@PostMapping(value="nuevoProducto", produces = "application/json")
	public Producto nuevoProducto(@RequestParam("nombre") String nombre, @RequestParam("descripcion")
	String descripcion, @RequestParam("precio") BigDecimal precio, @RequestParam("PId") Long Pid, 
	@RequestParam("stock") Integer Stock,@RequestParam("categoriaID") Long idCategoria)
	{
		Proveedor proveedor = new Proveedor();
		proveedor.setId(Pid);
		Categoria categoria = new Categoria();
		categoria.setId(idCategoria);
		
		Producto product = new Producto();
		
		product.setNombre(nombre);
		product.setDescripcion(descripcion);
		product.setPrecio(precio);
		product.setCreateAt(LocalDateTime.of(LocalDate.now(), LocalTime.now()));
		product.setProveedor(proveedor);
		product.setStock(Stock);
		product.setCategoria(categoria);
		
		return productoDAO.save(product);
		
	}
	/*
	@DeleteMapping(value = "/eliminar", produces ="application/json")
	public void eliminarProducto(@RequestParam("id") Long id)
	{
		
		
		productoDAO.deleteById(id);
	}
	*/
}
