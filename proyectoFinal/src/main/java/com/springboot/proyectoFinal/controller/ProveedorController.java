package com.springboot.proyectoFinal.controller;

import java.util.List;
import java.util.Optional;

import com.springboot.proyectoFinal.exception.BadRequestException;
import com.springboot.proyectoFinal.models.entity.Producto;
import com.springboot.proyectoFinal.servicios.contratos.ProveedorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.introspect.AccessorNamingStrategy.Provider;
import com.google.gson.Gson;
import com.springboot.proyectoFinal.models.entity.Proveedor;
import com.springboot.proyectoFinal.repositorios.ProveedorRepository;

@RestController
@RequestMapping("/proveedor")
public class ProveedorController {

    private final ProveedorDAO proveedorDAO;

    @Autowired
    public ProveedorController(ProveedorDAO proveedorDAO) {
        this.proveedorDAO = proveedorDAO;
    }

    @GetMapping(value = "/listar")
    public List<Proveedor> listar()
    {
        List<Proveedor> proveedores = (List<Proveedor>) proveedorDAO.findAll();
        if(proveedores.isEmpty()){
            throw new BadRequestException("No existen proveedores");
        }
        return proveedores;
    }

    //David
	/*@Autowired
	ProveedorRepository proveedorDAO;

	@GetMapping(value = "/listar", produces = "application/json")
	public String listar()
	{
		Gson json = new Gson();
		return json.toJson(proveedorDAO.findAll());
	}
	
	@PostMapping(value = "/nuevoProveedor", produces = "application/json")
	public Proveedor nuevoProveedor(@RequestParam("proveedor") String proveedor , @RequestParam("direccion") String direccion)
	{
		Proveedor prov = new Proveedor();
		
		prov.setNombre(proveedor);
		prov.setDireccion(direccion);
		
		return proveedorDAO.save(prov);
		
	}
	
	@GetMapping(value = "/porId", produces = "application/json")
	public Optional<Proveedor> ProveedorPorId(@RequestParam("id") Long id)
	{
		
		return proveedorDAO.findById(id);
		
	}
	
	@PutMapping(value="/actualizar", produces = "application/json")
	public Proveedor actualizarProveedor(@RequestParam("proveedor") String nombre, @RequestParam("direccion") String direccion, @RequestParam("id") Long id)
	{
		Optional<Proveedor>  provider = proveedorDAO.findById(id);
		Proveedor prov = provider.get();
		prov.setNombre(nombre);
		prov.setDireccion(direccion);
		return proveedorDAO.save(prov);
	}
	
	
	@DeleteMapping(value = "/eliminar", produces = "application/json")
	public void eliminarProveedor(@RequestParam("id") Long id)
	{
		
		proveedorDAO.deleteById(id);
	}*/
	
	

}
