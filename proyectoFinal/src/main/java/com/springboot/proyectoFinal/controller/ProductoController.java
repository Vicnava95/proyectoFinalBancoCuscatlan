package com.springboot.proyectoFinal.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import com.springboot.proyectoFinal.exception.BadRequestException;
import com.springboot.proyectoFinal.servicios.contratos.ProductoDAO;
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

	private final ProductoDAO productoDAO;

	@Autowired
	public ProductoController(ProductoDAO productoDAO) {
		this.productoDAO = productoDAO;
	}

	@GetMapping(value ="/listar")
	public List<Producto> listarProductos()
	{
		List<Producto> productos = (List<Producto>) productoDAO.findAll();
		if (productos.isEmpty()){
			throw new BadRequestException("No existen productos");
		}
		return productos;
	}

}
