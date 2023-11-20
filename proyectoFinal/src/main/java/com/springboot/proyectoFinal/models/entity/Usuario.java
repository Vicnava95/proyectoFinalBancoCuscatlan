package com.springboot.proyectoFinal.models.entity;

import com.springboot.proyectoFinal.models.entity.enumeradores.TipoUsuario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "persona_id")
public class Usuario extends Persona{
    
	
	@Column(name = "username")
	private String username;
	
	@Enumerated(EnumType.STRING)
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
