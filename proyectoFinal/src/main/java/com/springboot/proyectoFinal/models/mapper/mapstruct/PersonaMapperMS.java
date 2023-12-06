package com.springboot.proyectoFinal.models.mapper.mapstruct;

import com.springboot.proyectoFinal.models.dto.PersonaDTO;
import com.springboot.proyectoFinal.models.entity.Persona;

public interface PersonaMapperMS {

    PersonaDTO MapPersona(Persona persona);
}
