package com.springboot.proyectoFinal.models.mapper.mapstruct;

import com.springboot.proyectoFinal.models.dto.UsuarioDTO;
import com.springboot.proyectoFinal.models.entity.Usuario;
import org.mapstruct.Mapper;




public abstract class UsuarioMapper {

    public abstract UsuarioDTO mapUsuario(Usuario usuario);
    public abstract Usuario mapUsuario(UsuarioDTO usuarioDTO);

}
