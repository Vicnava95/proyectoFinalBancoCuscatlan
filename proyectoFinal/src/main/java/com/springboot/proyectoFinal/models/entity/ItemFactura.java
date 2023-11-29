package com.springboot.proyectoFinal.models.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "items_facturas")
public class ItemFactura implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer cantidad;
    @ManyToOne(
            optional = true,
            fetch = FetchType.EAGER
    )
    @JoinColumn(name = "producto_id")
    private Producto producto;

    

    public ItemFactura() {
    }

    public ItemFactura(Integer cantidad, Producto producto) {
        this.cantidad = cantidad;
        this.producto = producto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public BigDecimal calcularImporte(){
        return BigDecimal.valueOf(this.cantidad).multiply(producto.getPrecio());
    }

    @Override
    public String toString() {
        return "ItemFactura{" +
                "id=" + id +
                ", cantidad=" + cantidad +
                ", producto=" + producto.toString() +
                '}';
    }
    
    private static final long serialVersionUID = 1l;
}
