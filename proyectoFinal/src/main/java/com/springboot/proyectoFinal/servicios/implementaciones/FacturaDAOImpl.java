package com.springboot.proyectoFinal.servicios.implementaciones;

import com.springboot.proyectoFinal.models.entity.Factura;
import com.springboot.proyectoFinal.repositorios.FacturaRepository;
import com.springboot.proyectoFinal.servicios.contratos.FacturaDAO;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FacturaDAOImpl extends GenericDAOImpl<Factura, FacturaRepository> implements FacturaDAO {
    public FacturaDAOImpl(FacturaRepository repository) {
        super(repository);
    }

    @Override
    public Optional<Factura> buscarPorUsuarioID(Long id) {
        return repository.buscarPorUsuarioID(id);
    }
}
