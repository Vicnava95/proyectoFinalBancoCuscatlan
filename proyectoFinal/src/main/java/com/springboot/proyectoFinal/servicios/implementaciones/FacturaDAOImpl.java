package com.springboot.proyectoFinal.servicios.implementaciones;

import com.springboot.proyectoFinal.models.entity.Factura;
import com.springboot.proyectoFinal.repositorios.FacturaRepository;
import com.springboot.proyectoFinal.servicios.contratos.FacturaDAO;
import org.springframework.stereotype.Service;

@Service
public class FacturaDAOImpl extends GenericDAOImpl<Factura, FacturaRepository> implements FacturaDAO {
    public FacturaDAOImpl(FacturaRepository repository) {
        super(repository);
    }
}
