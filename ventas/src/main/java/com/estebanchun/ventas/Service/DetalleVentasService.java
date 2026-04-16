package com.estebanchun.ventas.Service;

import com.estebanchun.ventas.Entity.DetalleVentas;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DetalleVentasService {
    List<DetalleVentas> listar();
    DetalleVentas getDetalleVentasById(Integer id);
    DetalleVentas saveDetalleVentas(DetalleVentas detalleVentas) throws RuntimeException;
    DetalleVentas updateDetalleVentas(Integer id, DetalleVentas detalleVentas);
    void eliminar(int id);
}
