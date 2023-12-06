package com.springboot.proyectoFinal.controller;

import com.springboot.proyectoFinal.models.dto.PersonaDTO;
import com.springboot.proyectoFinal.models.entity.Persona;
import com.springboot.proyectoFinal.models.entity.Usuario;
import com.springboot.proyectoFinal.models.mapper.mapstruct.UsuarioMapper;
import com.springboot.proyectoFinal.servicios.contratos.PersonaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/usuarioDTOC")
@ConditionalOnProperty(prefix = "app", name = "controller-enable-dto", havingValue = "true")
public class UsuarioDTOController {

    @Autowired
   
    private PersonaDAO personaDAO;

    @Autowired
    private UsuarioMapper mapper;
    
    
    @GetMapping("/{id}")
    public PersonaDTO obtenerUsuariosporId(@PathVariable Long id)
    {
        Map<String , Object> mensaje = new HashMap<>();
        Optional<Persona> oPersona = personaDAO.findById(id);

        PersonaDTO dto = mapper.mapUsuario((Usuario)oPersona.get());

       mensaje.put("Success", Boolean.TRUE);
       mensaje.put("data", dto);
        //return ResponseEntity.ok(mensaje);
       
       return dto;
    }

    
   
    

}
