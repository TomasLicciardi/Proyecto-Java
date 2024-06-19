import Entities.*;
import Services.*;

public class Main {

    public static void main(String[] args) {
        GestorProducto gestorProducto = new GestorProducto();
        gestorProducto.crearProducto("Producto 1", "123", 10, 100.0);
        gestorProducto.crearProducto("Producto 2", "456", 20, 200.0);
        gestorProducto.crearProducto("Producto 3", "789", 30, 300.0);
        gestorProducto.crearProducto("Producto 4", "101", 40, 400.0);

        System.out.println("El producto 1 es: "+ gestorProducto.leerProducto(1));

        GestorCliente gestorCliente = new GestorCliente();
        gestorCliente.crearCliente("Juan", "Perez", 12345678);
        gestorCliente.crearCliente("Maria", "Gomez", 87654321);

        System.out.println("El cliente 1 es: "+ gestorCliente.leerCliente(1));
    }

}
