package com.www.elReyDelPollo.model.dto;

import com.www.elReyDelPollo.model.VentaDetalle;
import com.www.elReyDelPollo.model.enums.Naturaleza;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VentaDto {
    private String folio;
    private boolean status;
    private Naturaleza naturaleza;
    private float totalVenta;
    private LocalDateTime createdAt;
    private int idSucursal;
    private List<VentaDetalleDto> lvd;
}
