package com.springboot.proyectoFinal.models.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonaDTO {

	private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String contrasenia;

    
}
