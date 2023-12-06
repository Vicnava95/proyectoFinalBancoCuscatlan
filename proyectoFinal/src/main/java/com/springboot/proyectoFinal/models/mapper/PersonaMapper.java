package com.springboot.proyectoFinal.models.mapper;

import com.springboot.proyectoFinal.models.dto.CategoriaDTO;
import com.springboot.proyectoFinal.models.dto.PersonaDTO;
import com.springboot.proyectoFinal.models.entity.Categoria;
import com.springboot.proyectoFinal.models.entity.Persona;

public class PersonaMapper {

    public static PersonaDTO mapPersona(Persona persona)
    {
        PersonaDTO dto = new PersonaDTO();

        dto.setNombre(persona.getNombre());
        dto.setApellido(persona.getApellido());
        dto.setEmail(persona.getEmail());
        dto.setId(persona.getId());
        return dto;
    };
}
