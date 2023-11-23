package com.springboot.proyectoFinal.models.entity;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.*;
import org.hibernate.annotations.ValueGenerationType;

@Entity
@Table(name = "proveedores")
public class Proveedor implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nombre_proveedor")
    private String nombre;
	
	@Column(name = "direccion_proveedor")
    private String direccion;

    private static final long serialVersionUID = 1l;

    public Proveedor() {
    }

    public Proveedor(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    @Override
    public String toString() {
        return "Proveedor{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
