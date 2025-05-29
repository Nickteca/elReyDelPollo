package com.www.elReyDelPollo.service;

import com.www.elReyDelPollo.model.Venta;
import com.www.elReyDelPollo.model.VentaDetalle;
import com.www.elReyDelPollo.model.dto.VentaDetalleDto;
import com.www.elReyDelPollo.model.dto.VentaDto;
import com.www.elReyDelPollo.repository.VentaRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

    @Service
    @RequiredArgsConstructor
    public class VentaService {
        private final VentaRepo vr;

        public Venta save(VentaDto dto){
            Venta venta = new Venta();
            venta.setCreatedAt(LocalDateTime.now());
            venta.setTotalVenta(dto.getTotalVenta());
            venta.setNaturalezaVenta(dto.getNaturaleza());
            venta.setFolio(dto.getFolio());
            venta.setIdSucursal(dto.getIdSucursal());
            venta.setStatus(dto.isStatus());

            List<VentaDetalle> detalles = dto.getLvd().stream().map(d -> {
                VentaDetalle det = new VentaDetalle();
                det.setIdSucursalProducto(d.getIdSucursalProducto());
                det.setCantidad(d.getCantidad());
                det.setPrecio(d.getPrecio());
                det.setPeso(d.getPeso());
                det.setSubTotal(d.getSubtotal());
                det.setVenta(venta);
                return det;
            }).collect(Collectors.toList());

            venta.setListVentaDetalle(detalles);
            return vr.save(venta);
        }
    }
