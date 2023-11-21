package com.springboot.proyectoFinal.servicios.contratos;

import java.util.Optional;


import com.springboot.proyectoFinal.models.entity.Proveedor;

public interface ProveedorDAO extends GenericDAO<Proveedor> {
	
	 Optional<Proveedor> buscarPorNombre(String nombre);
	 Optional<Proveedor> buscarPorDireccion(String direccion);
}
