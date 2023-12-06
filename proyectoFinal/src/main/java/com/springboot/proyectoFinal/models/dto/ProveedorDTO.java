package com.springboot.proyectoFinal.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProveedorDTO {

    private String nombre;
    private String direccion;

    public ProveedorDTO(){};


}
