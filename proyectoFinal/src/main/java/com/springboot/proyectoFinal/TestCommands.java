package com.springboot.proyectoFinal;

import com.springboot.proyectoFinal.models.entity.Proveedor;
import com.springboot.proyectoFinal.servicios.contratos.CategoriaDAO;
import com.springboot.proyectoFinal.servicios.contratos.PersonaDAO;
import com.springboot.proyectoFinal.servicios.contratos.ProveedorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestCommands implements CommandLineRunner {

    @Autowired
    @Qualifier("usuarioDAOImpl")
    private PersonaDAO personaDAO;
    @Autowired
    private CategoriaDAO categoriaDAO;
    @Autowired
    private ProveedorDAO proveedorDAO;

    @Override
    public void run(String... args) throws Exception {
        Proveedor proveedor1 = new Proveedor("Intel", "Torre Esmeralda II, Blvd. Manuel Ávila Camacho 36, Lomas de Chapultepec, Miguel Hidalgo, 11000 Mexico City, CDMX, México");
        Proveedor proveedor2 = new Proveedor("Xiaomi","Metrocentro");

        proveedorDAO.save(proveedor1);
        proveedorDAO.save(proveedor2);

    }
}
