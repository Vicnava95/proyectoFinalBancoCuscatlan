package com.springboot.proyectoFinal.models.mapper;

import org.mapstruct.Mapper;

import com.springboot.proyectoFinal.models.dto.UsuarioDTO;
import com.springboot.proyectoFinal.models.entity.Usuario;

@Mapper(componentModel = "spring", config = UsuarioMapperConfig.class)
public abstract class UsuarioMapper {
	
	public abstract UsuarioDTO mapUsuario(Usuario usuario); 
	public abstract Usuario mapUsuario(UsuarioDTO usuarioDTO);

}
