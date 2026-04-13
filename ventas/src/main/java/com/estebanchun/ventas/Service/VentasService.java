package com.estebanchun.ventas.Service;

import com.estebanchun.ventas.Entity.Ventas;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VentasService {
    List<Ventas> getallVentas();
    Ventas getVentasById(Integer id);
    Ventas saveVentas(Ventas ventas) throws RuntimeException;
    Ventas updateVentas(Integer id, Ventas ventas);
    void delteVentas(Integer id);
}
