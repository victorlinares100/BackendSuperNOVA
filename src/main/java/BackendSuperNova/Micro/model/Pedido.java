package BackendSuperNova.Micro.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Pedido_id")
    private Long id;

    // Relación con Proveedor
    @ManyToOne
    @JoinColumn(name = "Proveedor_id")
    private Proveedor proveedor;

    @Column(name = "Fecha_emision")
    private LocalDate fechaEmision;

    @Column(name = "estado", length = 50)
    private String estado;

    @Column(name = "total", precision = 10, scale = 2)
    private BigDecimal total;
}
