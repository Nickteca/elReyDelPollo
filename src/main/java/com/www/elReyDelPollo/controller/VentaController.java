package com.www.elReyDelPollo.controller;

import com.www.elReyDelPollo.model.Venta;
import com.www.elReyDelPollo.model.VentaDetalle;
import com.www.elReyDelPollo.model.dto.VentaDetalleDto;
import com.www.elReyDelPollo.model.dto.VentaDto;
import com.www.elReyDelPollo.service.VentaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/ventas")
public class VentaController {

    private final VentaService vs;

    @PostMapping
    public ResponseEntity<Void> guardar(@RequestBody VentaDto dto) {
        Venta v = vs.save(dto);
       /* // 2) Mapeas manualmente a tu DTO de respuesta
        List<VentaDetalleDto> detallesDto = v.getListVentaDetalle().stream()
                .map(d -> new VentaDetalleDto(
                        d.getCantidad(),
                        d.getPeso(),
                        d.getPrecio(),
                        d.getSubTotal(),
                        d.getIdSucursalProducto()
                ))
                .toList();

        VentaDto response = new VentaDto(
                v.getFolio(),
                v.isStatus(),
                v.getNaturalezaVenta(),
                v.getTotalVenta(),
                v.getCreatedAt(),
                v.getIdSucursal(),
                detallesDto
        );*/

        // 3) Devuelves el DTO plano, no la entidad
        return ResponseEntity.ok().build();
        //return ResponseEntity.ok(vs.save(dto));
    }
}
