package com.springboot.proyectoFinal.datos;

import com.springboot.proyectoFinal.models.entity.*;
import com.springboot.proyectoFinal.models.entity.enumeradores.TipoUsuario;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DatosDummy {
    static LocalDateTime localDateTime = LocalDateTime.of(LocalDate.now(), LocalTime.now());

    public static Categoria categoria01(){
        return new Categoria("Televisores");
    }
    public static Categoria categoria02(){
        return new Categoria("Laptop");
    }
    public static Proveedor proveedor01(){
        return new Proveedor("Intel", "Torre Esmeralda II, Blvd. Manuel Ávila Camacho 36, Lomas de Chapultepec, Miguel Hidalgo, 11000 Mexico City, CDMX, México");
    }
    public static Proveedor proveedor02(){
        return new Proveedor("Xiaomi","Metrocentro");
    }
    public static Producto producto01(){
        return new Producto("NVidea4090", "Tarjeta gráfica", new BigDecimal(300.50),5,localDateTime);
    }
    public static Persona persona1(){
        return new Usuario("Víctor","Navarrete", "venm95@hotmail.com","hola123","vicnava95", TipoUsuario.PREMIUM);
    }
    public static Persona persona2(){
        return new Usuario("David","Ramos", "dr2495@gmail.com","hola123","david2392", TipoUsuario.PREMIUM);
    }


}
