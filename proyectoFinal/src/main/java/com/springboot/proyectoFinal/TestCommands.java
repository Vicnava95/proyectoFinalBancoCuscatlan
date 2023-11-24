package com.springboot.proyectoFinal;

import com.springboot.proyectoFinal.models.entity.*;
import com.springboot.proyectoFinal.models.entity.enumeradores.TipoUsuario;
import com.springboot.proyectoFinal.servicios.contratos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

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
    @Autowired
    private ItemFacturaDAO itemFacturaDAO;
    @Autowired
    private FacturaDAO facturaDAO;

    @Override
    public void run(String... args) throws Exception {
        Proveedor proveedor1 = new Proveedor("Intel", "Torre Esmeralda II, Blvd. Manuel Ávila Camacho 36, Lomas de Chapultepec, Miguel Hidalgo, 11000 Mexico City, CDMX, México");
        Proveedor proveedor2 = new Proveedor("Xiaomi","Metrocentro");
        proveedor1 = proveedorDAO.save(proveedor1);
        proveedor2 = proveedorDAO.save(proveedor2);

        Categoria categoria1 = new Categoria("Televisores");
        Categoria categoria2 = new Categoria("Laptop");
        categoria1 = categoriaDAO.save(categoria1);
        categoria2 = categoriaDAO.save(categoria2);


        Persona persona1 = new Usuario("Víctor","Navarrete", "venm95@hotmail.com","hola123","vicnava95", TipoUsuario.PREMIUM);
        Persona persona2 = new Usuario("David","Ramos", "dr2495@gmail.com","hola123","david2392", TipoUsuario.PREMIUM);
        persona1 = personaDAO.save(persona1);
        persona2 = personaDAO.save(persona2);

        LocalDateTime localDateTime = LocalDateTime.of(LocalDate.now(), LocalTime.now());

        Producto producto1 = new Producto("NVidea4090", "Tarjeta gráfica", new BigDecimal(300.50),5,localDateTime);
        producto1.setCategoria(categoria1);
        producto1.setProveedor(proveedor1);
        producto1 = productoDAO.save(producto1);

        ItemFactura itemFactura1 = new ItemFactura(2,producto1);
        ItemFactura itemFactura2 = new ItemFactura(3, productoDAO.findById(1L).get());
        itemFacturaDAO.save(itemFactura2);
        itemFacturaDAO.save(itemFactura1);

        Factura factura1 = new Factura("Primera factura",(Usuario) persona1);
        factura1.addItemFactura(itemFactura1);
        factura1.addItemFactura(itemFactura2);
        facturaDAO.save(factura1);

        Long idFactura = facturaDAO.findById(factura1.getId()).get().getId();
        System.out.println("El id de la factura es: " + idFactura);

        List<ItemFactura> items = factura1.getItems();
        items.forEach(System.out::println);
        System.out.println("El valor del total es: " + factura1.sumaTotal());

    }
}
