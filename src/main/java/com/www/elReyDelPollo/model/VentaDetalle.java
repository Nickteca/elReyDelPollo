package com.www.elReyDelPollo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VentaDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVentaDetalle;

    @Column(nullable = false)
    private short cantidad;
    // @Max(value=?) @Min(value=?)//if you know range of your decimal fields
    // consider using these annotations to enforce field validation
    @Column(nullable = true)
    private float peso =0;

    @Column(nullable = false)
    private float precio;

    @Column(nullable = false)
    private float subTotal;

    @Column(nullable = false)
    private int idSucursalProducto;

    @JoinColumn(name = "venta", referencedColumnName = "idVenta")
    @ManyToOne(optional = false)
    private Venta venta;
}