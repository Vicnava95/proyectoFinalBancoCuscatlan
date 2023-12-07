package com.springboot.proyectoFinal.models.entity;

import com.springboot.proyectoFinal.models.entity.enumeradores.TipoUsuario;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name = "persona_id")
public class Usuario extends Persona{
	@Column(name = "username")
	@NotEmpty
    private String username;
	@Enumerated(EnumType.STRING)
    @NotNull
    private TipoUsuario tipoUsuario;
	
	public Usuario() {};

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
