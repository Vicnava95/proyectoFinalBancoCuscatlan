package com.springboot.proyectoFinal.models.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "facturas")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String notas;
    private LocalDateTime createAt;
    @OneToMany(
            fetch =FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "factura_id")
    private List<ItemFactura> items;

    @ManyToOne(
            optional = true,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    private static final long serialVersionUID = 1l;

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
