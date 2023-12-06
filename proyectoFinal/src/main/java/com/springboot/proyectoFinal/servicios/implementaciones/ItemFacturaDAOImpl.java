package com.springboot.proyectoFinal.servicios.implementaciones;

import com.springboot.proyectoFinal.models.entity.Factura;
import com.springboot.proyectoFinal.models.entity.ItemFactura;
import com.springboot.proyectoFinal.models.entity.Producto;
import com.springboot.proyectoFinal.repositorios.ItemFacturaRepository;
import com.springboot.proyectoFinal.servicios.contratos.ItemFacturaDAO;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemFacturaDAOImpl extends GenericDAOImpl<ItemFactura, ItemFacturaRepository> implements ItemFacturaDAO {
    public ItemFacturaDAOImpl(ItemFacturaRepository repository) {
        super(repository);
    }

    @Override
    public Optional<ItemFactura> buscarPorIdProducto(Long id) {
        return repository.buscarPorIdProducto(id);
    }
}
