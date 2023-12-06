package com.springboot.proyectoFinal.servicios.implementaciones;

import com.springboot.proyectoFinal.repositorios.UsuarioRepository;
import com.springboot.proyectoFinal.servicios.contratos.UsuarioDAO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;

@SpringBootTest
class UsuarioDAOImplTest {
    @MockBean
    UsuarioRepository usuarioRepository;
    @Autowired
    UsuarioDAO usuarioDAO;

    @Test
    void buscarUsuarioPorUsername() {
        usuarioDAO.buscarUsuarioPorUsername(anyString());
        verify(usuarioRepository).buscarUsuarioPorUsername(anyString());
    }

}