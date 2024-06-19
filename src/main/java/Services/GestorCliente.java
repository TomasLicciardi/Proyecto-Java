package Services;

import Entities.*;
import jakarta.persistence.*;
import java.util.List;

public class GestorCliente {

    public void crearCliente(String nombre, String apellido, Integer dni) {
        EntityManager entityManager = GenericManager.getEntityManager();
        entityManager.getTransaction().begin();
        Cliente cliente = new Cliente(nombre, apellido, dni);
        entityManager.persist(cliente);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<Cliente> listarClientes() {
        EntityManager entityManager = GenericManager.getEntityManager();
        List<Cliente> clientes = entityManager.createQuery("FROM Cliente", Cliente.class).getResultList();
        entityManager.close();
        return clientes;
    }

    public Cliente obtenerPorID(Integer id) {
        EntityManager entityManager = GenericManager.getEntityManager();
        Cliente cliente = entityManager.find(Cliente.class, id);
        entityManager.close();
        return cliente;
    }

    public void actualizarCliente(Integer id, String nombre, String apellido, Integer dni) {
        EntityManager entityManager = GenericManager.getEntityManager();
        entityManager.getTransaction().begin();
        Cliente cliente = entityManager.find(Cliente.class, id);
        if (cliente != null){
            cliente.setNombre(nombre);
            cliente.setApellido(apellido);
            cliente.setDni(dni);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void eliminarCliente(Integer id) {
        EntityManager entityManager = GenericManager.getEntityManager();
        entityManager.getTransaction().begin();
        Cliente cliente = entityManager.find(Cliente.class, id);
        if (cliente != null){
            entityManager.remove(cliente);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
