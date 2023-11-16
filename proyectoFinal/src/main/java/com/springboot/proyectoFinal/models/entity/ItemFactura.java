package com.springboot.proyectoFinal.models.entity;

public class ItemFactura {
    private Long id;
    private Integer cantidad;
    private Producto producto;

    public ItemFactura(Long id, Integer cantidad, Producto producto) {
        this.id = id;
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

    @Override
    public String toString() {
        return "ItemFactura{" +
                "id=" + id +
                ", cantidad=" + cantidad +
                ", producto=" + producto.toString() +
                '}';
    }
}
