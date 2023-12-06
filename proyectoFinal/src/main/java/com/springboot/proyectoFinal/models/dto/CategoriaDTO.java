package com.springboot.proyectoFinal.models.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


public class CategoriaDTO {
	
	private String nombre;
	
	
	public CategoriaDTO() {}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
