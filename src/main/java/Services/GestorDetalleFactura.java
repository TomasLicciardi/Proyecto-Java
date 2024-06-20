package Services;

import Entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class GestorDetalleFactura {
    public void crearDetalleFactura(Integer monto, Factura factura, Producto producto) {
        EntityManager entityManager = null;
        EntityTransaction transaction;
        try {
            entityManager = GenericManager.get();
            transaction = entityManager.getTransaction();
            transaction.begin();
            DetalleFactura detalleFactura = new DetalleFactura();
            detalleFactura.setMonto(monto);
            detalleFactura.setPrecioUnitario(producto.getPrecio());
            detalleFactura.setId_factura(factura);
            detalleFactura.setId_producto(producto);
            entityManager.persist(detalleFactura);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error al crear el detalle de la factura: " + e.getMessage());
        } finally {
            GenericManager.closeEntity(entityManager);
        }
    }

    public DetalleFactura leerDetalleFactura(Integer id) {
        EntityManager entityManager = null;
        DetalleFactura detalleFactura = null;
        try {
            entityManager = GenericManager.get();
            detalleFactura = entityManager.find(DetalleFactura.class, id);
        } catch (Exception e) {
            System.out.println("Error al leer el detalle de la factura: " + e.getMessage());
        } finally {
            GenericManager.closeEntity(entityManager);
            return detalleFactura;
        }
    }

    public void eliminarDetalleFactura(Integer id) {
        EntityManager entityManager = null;
        EntityTransaction transaction;
        try {
            entityManager = GenericManager.get();
            transaction = entityManager.getTransaction();
            transaction.begin();
            DetalleFactura detalleFactura = entityManager.find(DetalleFactura.class, id);
            entityManager.remove(detalleFactura);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error al eliminar el detalle de la factura: " + e.getMessage());
        } finally {
            GenericManager.closeEntity(entityManager);
        }
    }
}
