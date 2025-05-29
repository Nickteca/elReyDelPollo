package com.www.elReyDelPollo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VentaDetalleDto {
    private short cantidad;
    private float peso;
    private float precio;
    private float subtotal;
    private int idSucursalProducto;
}
