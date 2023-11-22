package com.springboot.proyectoFinal;

import com.springboot.proyectoFinal.models.entity.Categoria;
import com.springboot.proyectoFinal.models.entity.Persona;
import com.springboot.proyectoFinal.models.entity.Proveedor;
import com.springboot.proyectoFinal.models.entity.Usuario;
import com.springboot.proyectoFinal.models.entity.enumeradores.TipoUsuario;
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

        Categoria categoria1 = new Categoria("Televisores");
        Categoria categoria2 = new Categoria("Laptop");

        Persona persona1 = new Usuario("Víctor","Navarrete", "venm95@hotmail.com","hola123","vicnava95", TipoUsuario.PREMIUM);
        Persona persona2 = new Usuario("David","Ramos", "dr2495@gmail.com","hola123","david2392", TipoUsuario.PREMIUM);

        proveedorDAO.save(proveedor1);
        proveedorDAO.save(proveedor2);

        categoriaDAO.save(categoria1);
        categoriaDAO.save(categoria2);

        personaDAO.save(persona1);
        personaDAO.save(persona2);

    }
}
