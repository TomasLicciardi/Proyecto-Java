package Services;

import Entities.*;
import jakarta.persistence.*;
import java.util.List;

public class GestorCliente {

    public void crearCliente(String nombre, String apellido, Integer dni) {
        EntityManager entityManager = null;
        EntityTransaction transaction;
        try {
            entityManager = GenericManager.get();
            transaction = entityManager.getTransaction();
            transaction.begin();
            Cliente cliente = new Cliente();
            cliente.setNombre(nombre);
            cliente.setApellido(apellido);
            cliente.setDni(dni);
            entityManager.persist(cliente);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error al crear el cliente: " + e.getMessage());
        } finally {
            GenericManager.closeEntity(entityManager);
        }
    }

    public Cliente leerCliente (Integer id) {
        EntityManager entityManager = null;
        Cliente cliente = null;
        try {
            entityManager = GenericManager.get();
            cliente = entityManager.find(Cliente.class, id);
        } catch (Exception e) {
            System.out.println("Error al leer el cliente: " + e.getMessage());
        } finally {
            GenericManager.closeEntity(entityManager);
            return cliente;
        }

    }


    public List<Cliente> obtenerClientes() {
        EntityManager entityManager = null;
        List<Cliente> clientes = null;
        try {
            entityManager = GenericManager.get();
            clientes = entityManager.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
        } catch (Exception e) {
            System.out.println("Error al obtener los clientes: " + e.getMessage());
        } finally {
            GenericManager.closeEntity(entityManager);
            return clientes;
        }
    }

    public List<Cliente> obtenerClientesPorNombre(String nombre) {
        EntityManager entityManager = null;
        List<Cliente> clientes = null;
        try {
            entityManager = GenericManager.get();
            clientes = entityManager.createQuery("SELECT c FROM Cliente c WHERE c.nombre = :nombre", Cliente.class)
                    .setParameter("nombre", nombre).getResultList();
        } catch (Exception e) {
            System.out.println("Error al obtener los clientes: " + e.getMessage());
        } finally {
            GenericManager.closeEntity(entityManager);
            return clientes;
        }
    }

    public void actualizarCliente(Integer id, String nombre, String apellido, Integer dni) {
        EntityManager entityManager = null;
        EntityTransaction transaction;
        try {
            entityManager = GenericManager.get();
            transaction = entityManager.getTransaction();
            transaction.begin();
            Cliente cliente = entityManager.find(Cliente.class, id);
            cliente.setNombre(nombre);
            cliente.setApellido(apellido);
            cliente.setDni(dni);
            entityManager.merge(cliente);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error al actualizar el cliente: " + e.getMessage());
        } finally {
            GenericManager.closeEntity(entityManager);
        }
    }

    public void eliminarCliente(Integer id) {
        EntityManager entityManager = null;
        EntityTransaction transaction;
        try {
            entityManager = GenericManager.get();
            transaction = entityManager.getTransaction();
            transaction.begin();
            Cliente cliente = entityManager.find(Cliente.class, id);
            entityManager.remove(cliente);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error al eliminar el cliente: " + e.getMessage());
        } finally {
            GenericManager.closeEntity(entityManager);
        }
    }

}
