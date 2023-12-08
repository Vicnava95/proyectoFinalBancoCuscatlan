package com.springboot.proyectoFinal.controller.dto;

import com.springboot.proyectoFinal.models.dto.ProveedorDTO;
import com.springboot.proyectoFinal.models.entity.Proveedor;
import com.springboot.proyectoFinal.models.mapper.ProveedorMapper;
import com.springboot.proyectoFinal.servicios.contratos.ProveedorDAO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/proveedor")
public class ProveedorDtoController extends GenericDtoController<Proveedor, ProveedorDAO>{
    private ProveedorMapper mapper;
    public ProveedorDtoController(ProveedorDAO service) {
        super(service, "Proveedor");
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listar(){
        Map<String, Object> mensaje = new HashMap<>();
        List<Proveedor> proveedor =  super.obtenerTodos();

        if (proveedor.isEmpty()){
            mensaje.put("success",Boolean.FALSE);
            mensaje.put("datos",proveedor);
            return ResponseEntity.badRequest().body(mensaje);
        }

        List<ProveedorDTO> proveedorDtos = proveedor
                .stream()
                .map(ProveedorMapper::mapProveedor)
                .collect(Collectors.toList());

        mensaje.put("success",Boolean.TRUE);
        mensaje.put("datos",proveedorDtos);

        return ResponseEntity.ok(mensaje);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerPorId(@PathVariable Long id){
        Map<String, Object> mensaje = new HashMap<>();

        Optional<Proveedor> optionalProveedor = super.buscarPorId(id);
        Proveedor proveedor = optionalProveedor.orElse(null);
        if (proveedor == null){
            /*throw new BadRequestException(String.format("El id de %s no se ha encontrado",nombreEntidad));*/
            mensaje.put("success",Boolean.FALSE);
            mensaje.put("mensaje",String.format("El id de %s no se ha encontrado",nombreEntidad));
            return ResponseEntity.badRequest().body(mensaje);
        }

        ProveedorDTO proveedorDtos = ProveedorMapper.mapProveedor(proveedor);
        mensaje.put("success",Boolean.TRUE);
        mensaje.put("datos",proveedorDtos);

        return ResponseEntity.ok(mensaje);
    }

    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody Proveedor proveedor, BindingResult result){
        //Validaciones
        super.obtenerValidaciones(result);
        super.crearEntidad(proveedor);
        Map<String, Object> mensaje = new HashMap<>();

        ProveedorDTO proveedorDTOs = ProveedorMapper.mapProveedor(proveedor);
        mensaje.put("success",Boolean.TRUE);
        mensaje.put("datos",proveedorDTOs);
        return ResponseEntity.ok(mensaje);
    }

    @DeleteMapping(value = "/{id}")
    public void eliminar(@PathVariable Long id){
        super.eliminarPorId(id);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id,@Valid @RequestBody Proveedor proveedor, BindingResult result){
        Map<String, Object> mensaje = new HashMap<>();
        Optional<Proveedor> optionalProveedor = super.buscarPorId(id);
        Proveedor proveedor1 = optionalProveedor.get();
        if (proveedor1 == null){
            /*throw new BadRequestException(String.format("El id de %s no se ha encontrado",nombreEntidad));*/
            mensaje.put("success",Boolean.FALSE);
            mensaje.put("mensaje",String.format("El id de %s no se ha encontrado",nombreEntidad));
            return ResponseEntity.badRequest().body(mensaje);
        }
        proveedor1.setNombre(proveedor.getNombre());
        proveedor1.setDireccion(proveedor.getDireccion());
        service.save(proveedor1);

        ProveedorDTO proveedorDTOs = ProveedorMapper.mapProveedor(proveedor1);
        mensaje.put("success",Boolean.TRUE);
        mensaje.put("datos",proveedorDTOs);

        return ResponseEntity.ok(mensaje);
    }
}
