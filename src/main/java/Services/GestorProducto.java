package Services;

import Entities.Producto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class GestorProducto {

    public void crearProducto(String descripcion,String codigo,Integer stock, Double precio) {
        EntityManager entityManager = null;
        EntityTransaction transaction;
        try {
            entityManager = GenericManager.get();
            transaction = entityManager.getTransaction();
            transaction.begin();
            Producto producto = new Producto();
            producto.setDescripcion(descripcion);
            producto.setCodigo(codigo);
            producto.setStock(stock);
            producto.setPrecio(precio);
            entityManager.persist(producto);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error al crear el producto: " + e.getMessage());
        } finally {
            GenericManager.closeEntity(entityManager);
        }
    }

    public Producto leerProducto (Integer id) {
        EntityManager entityManager = null;
        Producto producto = null;
        try {
            entityManager = GenericManager.get();
            producto = entityManager.find(Producto.class, id);
        } catch (Exception e) {
            System.out.println("Error al leer el producto: " + e.getMessage());
        } finally {
            GenericManager.closeEntity(entityManager);
            return producto;
        }

    }

    public List<Producto> obtenerProductos() {
        EntityManager entityManager = null;
        List<Producto> productos = null;
        try {
            entityManager = GenericManager.get();
            productos = entityManager.createQuery("SELECT p FROM Producto p", Producto.class).getResultList();
        } catch (Exception e) {
            System.out.println("Error al obtener los productos: " + e.getMessage());
        } finally {
            GenericManager.closeEntity(entityManager);
            return productos;
        }
    }

    public List<Producto> obtenerProductosPorDescripcion(String descripcion) {
        EntityManager entityManager = null;
        List<Producto> productos = null;
        try {
            entityManager = GenericManager.get();
            productos = entityManager.createQuery("SELECT p FROM Producto p WHERE p.descripcion = :descripcion", Producto.class)
                    .setParameter("descripcion", descripcion)
                    .getResultList();
        } catch (Exception e) {
            System.out.println("Error al obtener los productos: " + e.getMessage());
        } finally {
            GenericManager.closeEntity(entityManager);
            return productos;
        }
    }

    public void actualizarProducto(Integer id, String descripcion, String codigo, Integer stock, Double precio) {
        EntityManager entityManager = null;
        EntityTransaction transaction;
        try {
            entityManager = GenericManager.get();
            transaction = entityManager.getTransaction();
            transaction.begin();
            Producto producto = entityManager.find(Producto.class, id);
            producto.setDescripcion(descripcion);
            producto.setCodigo(codigo);
            producto.setStock(stock);
            producto.setPrecio(precio);
            entityManager.persist(producto);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error al actualizar el producto: " + e.getMessage());
        } finally {
            GenericManager.closeEntity(entityManager);
        }
    }

    public void eliminarProducto(Integer id) {
        EntityManager entityManager = null;
        EntityTransaction transaction;
        try {
            entityManager = GenericManager.get();
            transaction = entityManager.getTransaction();
            transaction.begin();
            Producto producto = entityManager.find(Producto.class, id);
            entityManager.remove(producto);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error al eliminar el producto: " + e.getMessage());
        } finally {
            GenericManager.closeEntity(entityManager);
        }
    }

}
