import Entities.*;
import Services.*;

import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {
        GestorProducto gestorProducto = new GestorProducto();
        //gestorProducto.crearProducto("Producto 1", "123", 10, 100.0);
        //gestorProducto.crearProducto("Producto 2", "456", 20, 200.0);
        //gestorProducto.crearProducto("Producto 3", "789", 30, 300.0);
        //gestorProducto.crearProducto("Producto 4", "101", 40, 400.0);


        System.out.println("El producto 1 es: "+ gestorProducto.leerProducto(1));

        GestorCliente gestorCliente = new GestorCliente();
        //gestorCliente.crearCliente("Juan", "Perez", 12345678);
        //gestorCliente.crearCliente("Maria", "Gomez", 87654321);

        System.out.println("El cliente 1 es: "+ gestorCliente.leerCliente(1));

        GestorFactura gestorFactura = new GestorFactura();
       // gestorFactura.crearFactura(LocalDateTime.now(), 100.0, gestorCliente.leerCliente(1));
       // gestorFactura.crearFactura(LocalDateTime.now(), 200.0, gestorCliente.leerCliente(2));

        System.out.println("La factura 1 es: "+ gestorFactura.leerFactura(1));
        System.out.println("La factura 2 es: "+ gestorFactura.leerFactura(2));


        GestorDetalleFactura gestorDetalleFactura = new GestorDetalleFactura();
        //gestorDetalleFactura.crearDetalleFactura(100, gestorFactura.leerFactura(1), gestorProducto.leerProducto(1));
        //gestorDetalleFactura.crearDetalleFactura(200, gestorFactura.leerFactura(1), gestorProducto.leerProducto(2));
        //gestorDetalleFactura.crearDetalleFactura(300, gestorFactura.leerFactura(2), gestorProducto.leerProducto(3));

        System.out.println("El detalle de la factura 1 es: "+ gestorDetalleFactura.leerDetalleFactura(1));

        //gestorFactura.eliminarFactura(gestorFactura.leerFactura(1));
        gestorProducto.eliminarProducto(1);
    }

}
