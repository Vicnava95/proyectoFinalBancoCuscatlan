package com.springboot.proyectoFinal.models.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Factura {
    private Long id;
    private String notas;
    private LocalDateTime createAt;
    private List<ItemFactura> items;

    public Factura() {
        this.items =new ArrayList<ItemFactura>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public List<ItemFactura> getItems() {
        return items;
    }
    public void setItems(List<ItemFactura> items) {
        this.items = items;
    }
    public void addItemFactura(ItemFactura itemFactura){
        items.add(itemFactura);
    }
}
