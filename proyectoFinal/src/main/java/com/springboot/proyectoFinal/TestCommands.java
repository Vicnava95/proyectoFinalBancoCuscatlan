package com.springboot.proyectoFinal;

import com.springboot.proyectoFinal.models.entity.*;
import com.springboot.proyectoFinal.models.entity.enumeradores.TipoUsuario;
import com.springboot.proyectoFinal.servicios.contratos.CategoriaDAO;
import com.springboot.proyectoFinal.servicios.contratos.PersonaDAO;
import com.springboot.proyectoFinal.servicios.contratos.ProductoDAO;
import com.springboot.proyectoFinal.servicios.contratos.ProveedorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Component
public class TestCommands implements CommandLineRunner {

    @Autowired
    @Qualifier("usuarioDAOImpl")
    private PersonaDAO personaDAO;
    @Autowired
    private CategoriaDAO categoriaDAO;
    @Autowired
    private ProveedorDAO proveedorDAO;

    @Autowired
    private ProductoDAO productoDAO;

    @Override
    public void run(String... args) throws Exception {
        Proveedor proveedor1 = new Proveedor("Intel", "Torre Esmeralda II, Blvd. Manuel Ávila Camacho 36, Lomas de Chapultepec, Miguel Hidalgo, 11000 Mexico City, CDMX, México");
        Proveedor proveedor2 = new Proveedor("Xiaomi","Metrocentro");
        proveedorDAO.save(proveedor1);
        proveedorDAO.save(proveedor2);

        Categoria categoria1 = new Categoria("Televisores");
        Categoria categoria2 = new Categoria("Laptop");
        categoriaDAO.save(categoria1);
        categoriaDAO.save(categoria2);


        Persona persona1 = new Usuario("Víctor","Navarrete", "venm95@hotmail.com","hola123","vicnava95", TipoUsuario.PREMIUM);
        Persona persona2 = new Usuario("David","Ramos", "dr2495@gmail.com","hola123","david2392", TipoUsuario.PREMIUM);
        personaDAO.save(persona1);
        personaDAO.save(persona2);

        LocalDateTime localDateTime = LocalDateTime.of(LocalDate.now(), LocalTime.now());

        Producto producto1 = new Producto("NVidea4090", "Tarjeta gráfica", new BigDecimal(300.50),5,localDateTime);
        producto1.setCategoria(categoria1);
        producto1.setProveedor(proveedor1);
        productoDAO.save(producto1);

    }
}
