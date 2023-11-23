package com.springboot.proyectoFinal.servicios.implementaciones;

import com.springboot.proyectoFinal.models.entity.Producto;
import com.springboot.proyectoFinal.repositorios.ProductoRepository;
import com.springboot.proyectoFinal.servicios.contratos.ProductoDAO;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ProductoDAOImpl extends GenericDAOImpl<Producto, ProductoRepository> implements ProductoDAO {
    public ProductoDAOImpl(ProductoRepository repository) {
        super(repository);
    }

    @Override
    public Optional<Producto> buscarProductoPorNombre(String nombre) {
        return repository.buscarProductoPorNombre(nombre);
    }
}
