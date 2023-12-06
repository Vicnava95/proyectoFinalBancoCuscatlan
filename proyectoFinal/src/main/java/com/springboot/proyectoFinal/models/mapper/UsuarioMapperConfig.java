package com.springboot.proyectoFinal.models.mapper;

import org.mapstruct.InheritConfiguration;
import org.mapstruct.MapperConfig;
import org.mapstruct.MappingTarget;

import com.springboot.proyectoFinal.models.dto.UsuarioDTO;
import com.springboot.proyectoFinal.models.entity.Usuario;

@MapperConfig
public interface UsuarioMapperConfig extends PersonaMapperConfig {
	
	@InheritConfiguration(name = "mapPersona")
	void mapUsuario(Usuario usuario, @MappingTarget UsuarioDTO usuarioDTO );

}
