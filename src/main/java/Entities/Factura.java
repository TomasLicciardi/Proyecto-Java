package Entities;


import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "Facturas")
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime fecha;

    @Column
    private Double total;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente id_cliente;

    @OneToMany(mappedBy = "id_factura",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleFactura> detallesFacturas;

    public Factura() {}

    public List<DetalleFactura> getDetallesFacturas() {
        return detallesFacturas;
    }

    public void setDetallesFacturas(List<DetalleFactura> detallesFacturas) {
        this.detallesFacturas = detallesFacturas;
    }

    public Cliente getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Cliente id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Factura factura = (Factura) o;
        return Objects.equals(id, factura.id) && Objects.equals(fecha, factura.fecha) && Objects.equals(total, factura.total) && Objects.equals(id_cliente, factura.id_cliente) && Objects.equals(detallesFacturas, factura.detallesFacturas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fecha, total, id_cliente, detallesFacturas);
    }

    @Override
    public String toString() {
        return "Factura{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", total=" + total +
                ", id_cliente=" + id_cliente +
                //", detallesFacturas=" + detallesFacturas +
                '}';
    }
}
