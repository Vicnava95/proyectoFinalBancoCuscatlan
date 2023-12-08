package com.springboot.proyectoFinal.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaDTO {
    private Long codigo;
    private String nombre;

}
