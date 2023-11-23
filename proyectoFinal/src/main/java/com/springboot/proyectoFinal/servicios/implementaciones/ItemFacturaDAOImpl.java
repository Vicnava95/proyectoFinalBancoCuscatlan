package com.springboot.proyectoFinal.servicios.implementaciones;

import com.springboot.proyectoFinal.models.entity.ItemFactura;
import com.springboot.proyectoFinal.repositorios.ItemFacturaRepository;
import com.springboot.proyectoFinal.servicios.contratos.ItemFacturaDAO;
import org.springframework.stereotype.Service;

@Service
public class ItemFacturaDAOImpl extends GenericDAOImpl<ItemFactura, ItemFacturaRepository> implements ItemFacturaDAO {
    public ItemFacturaDAOImpl(ItemFacturaRepository repository) {
        super(repository);
    }
}
