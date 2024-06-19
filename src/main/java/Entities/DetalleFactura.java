package Entities;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Detalles_Facturas")
public class DetalleFactura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Integer monto;

    @Column
    private Double precio_unitario;

    @ManyToOne
    @JoinColumn(name = "id_factura")
    private Factura id_factura;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto id_producto;


    public DetalleFactura() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMonto() {
        return monto;
    }

    public void setMonto(Integer monto) {
        this.monto = monto;
    }

    public Double getPrecioUnitario() {
        return precio_unitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precio_unitario = precioUnitario;
    }

    public Factura getId_factura() {
        return id_factura;
    }

    public void setId_factura(Factura id_factura) {
        this.id_factura = id_factura;
    }

    public Producto getId_producto() {
        return id_producto;
    }

    public void setId_producto(Producto id_producto) {
        this.id_producto = id_producto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DetalleFactura that = (DetalleFactura) o;
        return Objects.equals(id, that.id) && Objects.equals(monto, that.monto) && Objects.equals(precio_unitario, that.precio_unitario) && Objects.equals(id_factura, that.id_factura) && Objects.equals(id_producto, that.id_producto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, monto, precio_unitario, id_factura, id_producto);
    }

    @Override
    public String toString() {
        return "DetalleFactura{" +
                "id=" + id +
                ", monto=" + monto +
                ", precioUnitario=" + precio_unitario +
                ", id_factura=" + id_factura +
                ", id_producto=" + id_producto +
                '}';
    }
}
