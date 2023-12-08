package com.springboot.proyectoFinal.models.mapper;

import com.springboot.proyectoFinal.models.dto.ProveedorDTO;
import com.springboot.proyectoFinal.models.entity.Proveedor;
import org.springframework.stereotype.Component;

@Component
public class ProveedorMapper {
    public static ProveedorDTO mapProveedor(Proveedor proveedor){
        ProveedorDTO dto = new ProveedorDTO();
        dto.setNombre(proveedor.getNombre());
        dto.setDireccion(proveedor.getDireccion());
        return dto;
    }
}
