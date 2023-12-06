package com.springboot.proyectoFinal.models.mapper;

import org.mapstruct.MapperConfig;
import org.mapstruct.MappingTarget;

import com.springboot.proyectoFinal.models.dto.PersonaDTO;
import com.springboot.proyectoFinal.models.entity.Persona;

@MapperConfig
public interface PersonaMapperConfig {
	
	void mapPersona(Persona persona, @MappingTarget PersonaDTO personaDTO );

}
