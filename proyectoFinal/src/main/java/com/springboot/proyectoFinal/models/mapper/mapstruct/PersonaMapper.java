package com.springboot.proyectoFinal.models.mapper.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import com.springboot.proyectoFinal.models.dto.UsuarioDTO;
import com.springboot.proyectoFinal.models.entity.Usuario;

@Mapper
@Component
public interface PersonaMapper {
	
	PersonaMapper mapper = Mappers.getMapper(PersonaMapper.class);
	
	UsuarioDTO mapUsuario(Usuario usuario);

}
