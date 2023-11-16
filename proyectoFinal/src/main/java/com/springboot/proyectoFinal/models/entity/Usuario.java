package com.springboot.proyectoFinal.models.entity;

import com.springboot.proyectoFinal.models.entity.enumeradores.TipoUsuario;

public class Usuario extends Persona{
    private String username;
    private TipoUsuario tipoUsuario;
    public Usuario(Long id, String nombre, String apellido, String email, String contrasenia, String username, TipoUsuario tipoUsuario) {
        super(id, nombre, apellido, email, contrasenia);
        this.username = username;
        this.tipoUsuario = tipoUsuario;
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

    @Override
    public String toString() {
        return super.toString() +
                "username='" + username + '\'' +
                ", tipoUsuario=" + tipoUsuario +
                '}';
    }
}
