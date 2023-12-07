package com.springboot.proyectoFinal.controller;

import com.google.gson.Gson;
import com.springboot.proyectoFinal.exception.BadRequestException;
import com.springboot.proyectoFinal.models.entity.Factura;
import com.springboot.proyectoFinal.models.entity.ItemFactura;
import com.springboot.proyectoFinal.models.entity.Producto;
import com.springboot.proyectoFinal.repositorios.FacturaRepository;
import com.springboot.proyectoFinal.repositorios.ItemFacturaRepository;
import com.springboot.proyectoFinal.repositorios.ProductoRepository;
import com.springboot.proyectoFinal.servicios.contratos.ItemFacturaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/itemsFactura")
public class ItemFacturaController extends GenericController<ItemFactura, ItemFacturaDAO>{
    @Autowired
    public ItemFacturaController(ItemFacturaDAO service) {
        super(service);
    }
    //David
    /*@Autowired
    ItemFacturaRepository itemFacturaDAO;

    @Autowired
    ProductoRepository productoDAO;

    @Autowired
    FacturaRepository facturaDAO;

    @GetMapping(value = "/listar", produces = "application/json")
    public Iterable<ItemFactura> listar(){
        return itemFacturaDAO.findAll();
    }

    @PostMapping(value = "/nuevoItem", produces = "application/json")
    public ItemFactura nuevoItem(@RequestParam("cantidad") Integer cantidad, @RequestParam("producto")Long productoID, @RequestParam("factura")Long facturaID){
        Optional<Producto> producto = productoDAO.findById(productoID);
        ItemFactura item = new ItemFactura(cantidad,producto.get());
        Optional<Factura> factura = facturaDAO.findById(facturaID);
        factura.get().addItemFactura(item);
        return itemFacturaDAO.save(item);
    }

    @GetMapping(value = "/porId", produces = "application/json")
    public Optional<ItemFactura> ItemFacturaPorId(@RequestParam("id") Long id){
        return itemFacturaDAO.findById(id);
    }

    @PutMapping(value = "/actualizar", produces = "application/json")
    public ItemFactura actualizarItem(@RequestParam("id") Long id, @RequestParam("cantidad") Integer cantidad, @RequestParam("prodcuto") Long idProducto){
        Optional<ItemFactura> item = itemFacturaDAO.findById(id);
        Optional<Producto> producto = productoDAO.findById(idProducto);
        item.get().setCantidad(cantidad);
        item.get().setProducto(producto.get());
        return itemFacturaDAO.save(item.get());
    }

    @DeleteMapping(value = "/eliminar", produces = "application/json")
    public void eliminarItem(@RequestParam("id") Long id){
        itemFacturaDAO.deleteById(id);
    }*/


}
