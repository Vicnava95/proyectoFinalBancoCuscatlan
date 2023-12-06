package com.springboot.proyectoFinal.models.dto;

import lombok.Data;


public class categoriaDTO {

    private String categoria;

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public categoriaDTO(String categoria) {
        this.categoria = categoria;
    }

    public categoriaDTO() {

    }
}
