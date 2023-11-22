package com.springboot.proyectoFinal.models.entity;

import com.springboot.proyectoFinal.models.entity.enumeradores.TipoUsuario;

import jakarta.persistence.*;

import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name = "persona_id")
public class Usuario extends Persona{
	@Column(name = "username")
	private String username;
	
	@Enumerated(EnumType.STRING)
    private TipoUsuario tipoUsuario;

    public Usuario(String nombre, String apellido, String email, String contrasenia, String username, TipoUsuario tipoUsuario) {
        super(nombre, apellido, email, contrasenia);
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
