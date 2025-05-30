package com.www.elReyDelPollo.model;

import com.www.elReyDelPollo.model.enums.Naturaleza;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(indexes = { @Index(name = "indexFechaVenta", columnList = "createdAt"), @Index(name = "indexFolii",columnList = "folio") })
public class Venta{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVenta;

    @Column(nullable = false, length = 17)
    private String folio;

    @Column(nullable = false)
    private boolean status;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private Naturaleza naturalezaVenta;

    // @Max(value=?) @Min(value=?)//if you know range of your decimal fields
    // consider using these annotations to enforce field validation
    @Column(nullable = false)
    private float totalVenta;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = true)
    private LocalDateTime updatedAt;

    @Column(nullable = false)
    private boolean enviado;

    @Column(nullable = false)
    private int idSucursal;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "venta")
    private List<VentaDetalle> listVentaDetalle;
}