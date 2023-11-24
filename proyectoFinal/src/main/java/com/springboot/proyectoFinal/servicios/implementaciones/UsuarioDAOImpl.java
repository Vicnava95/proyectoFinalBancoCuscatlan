package com.springboot.proyectoFinal.servicios.implementaciones;

import com.springboot.proyectoFinal.models.entity.Persona;
import com.springboot.proyectoFinal.models.entity.Usuario;
import com.springboot.proyectoFinal.repositorios.PersonaRepository;
import com.springboot.proyectoFinal.repositorios.UsuarioRepository;
import com.springboot.proyectoFinal.servicios.contratos.UsuarioDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioDAOImpl extends PersonaDAOImpl implements UsuarioDAO {
	
	
	
	
    public UsuarioDAOImpl(@Qualifier("repositorioUsuario") PersonaRepository repository) {
        super(repository);
    }

    @Override
    public Optional<Usuario> buscarUsuarioPorUsername(String username) {
        return ((UsuarioRepository)repository).buscarUsuarioPorUsername(username);
    }

	@Override
	public Optional<Usuario> FindByIdd(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	
	
}
