package Services;

import Entities.Cliente;
import Entities.Factura;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.time.LocalDateTime;

public class GestorFactura {

    public void crearFactura(LocalDateTime fecha, Double total, Cliente cliente){
        EntityManager entityManager = null;
        EntityTransaction transaction;
        try {
            entityManager = GenericManager.get();
            transaction = entityManager.getTransaction();
            transaction.begin();
            Factura factura = new Factura();
            factura.setFecha(fecha);
            factura.setTotal(total);
            factura.setId_cliente(cliente);
            entityManager.persist(factura);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error al crear la factura: " + e.getMessage());
        } finally {
            GenericManager.closeEntity(entityManager);
        }
    }

    public Factura leerFactura (Integer id) {
        EntityManager entityManager = null;
        Factura factura = null;
        try {
            entityManager = GenericManager.get();
            factura = entityManager.find(Factura.class, id);
        } catch (Exception e) {
            System.out.println("Error al leer la factura: " + e.getMessage());
        } finally {
            GenericManager.closeEntity(entityManager);
            return factura;
        }

    }

    public void actualizarFactura(Factura factura){
        EntityManager entityManager = null;
        EntityTransaction transaction;
        try {
            entityManager = GenericManager.get();
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.merge(factura);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error al actualizar la factura: " + e.getMessage());
        } finally {
            GenericManager.closeEntity(entityManager);
        }
    }

    public void eliminarFactura(Factura factura){
        EntityManager entityManager = null;
        EntityTransaction transaction;
        try {
            entityManager = GenericManager.get();
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.remove(entityManager.contains(factura) ? factura : entityManager.merge(factura));
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error al eliminar la factura: " + e.getMessage());
        } finally {
            GenericManager.closeEntity(entityManager);
        }
    }

}
