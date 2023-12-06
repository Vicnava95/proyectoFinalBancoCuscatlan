package com.springboot.proyectoFinal.models.dto;

import com.springboot.proyectoFinal.models.entity.enumeradores.TipoUsuario;

public class UsuarioDTO extends PersonaDTO{

    private String username;
    private TipoUsuario tipoUsuario;

    public UsuarioDTO(Long id, String nombre, String apellido, String correo, String username, TipoUsuario tipoUsuario) {
        super(id, nombre, apellido, correo);
        this.username = username;
        this.tipoUsuario = tipoUsuario;
    }

    public UsuarioDTO() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
