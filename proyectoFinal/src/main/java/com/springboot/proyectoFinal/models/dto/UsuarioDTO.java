package com.springboot.proyectoFinal.models.dto;


import com.springboot.proyectoFinal.models.entity.enumeradores.TipoUsuario;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class UsuarioDTO  extends PersonaDTO{
	
	

	@NotEmpty
	private String username;
	
	@Enumerated(EnumType.STRING)
    @NotNull
	private TipoUsuario tipoUsuario;

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

	public UsuarioDTO(Long id, String nombre, String apellido, String email, @NotEmpty String username,
			@NotNull TipoUsuario tipoUsuario) {
		super(id, nombre, apellido, email);
		this.username = username;
		this.tipoUsuario = tipoUsuario;
	}
	
	
	public UsuarioDTO() {};

	
	
	
		



	
	

}
