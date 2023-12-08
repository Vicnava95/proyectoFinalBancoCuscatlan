package com.springboot.proyectoFinal.models.dto;

import com.springboot.proyectoFinal.models.entity.Categoria;
import com.springboot.proyectoFinal.models.entity.Proveedor;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public class ProductoDTO {

    @NotEmpty
    private String nombre;
    @NotEmpty
    private String descripcion;
    @Positive
    private BigDecimal precio;
    @Min(0)
    private Integer stock;

    public ProductoDTO(String nombre, String descripcion, BigDecimal precio, Integer stock) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
    }

    public ProductoDTO(){};
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
