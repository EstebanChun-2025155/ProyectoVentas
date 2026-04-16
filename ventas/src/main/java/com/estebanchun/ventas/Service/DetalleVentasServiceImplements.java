package com.estebanchun.ventas.Service;

import com.estebanchun.ventas.Entity.DetalleVentas;
import com.estebanchun.ventas.Repository.ClientesRepository;
import com.estebanchun.ventas.Repository.DetalleVentasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleVentasServiceImplements implements DetalleVentasService {
    @Autowired
    private DetalleVentasRepository repo;

    @Override
    public List<DetalleVentas> listar() {
        return repo.findAll();
    }

    @Override
    public DetalleVentas getDetalleVentasById(Integer id) {
         return repo.findById(id).orElseThrow(() -> new RuntimeException("Detalle De Venta no encontrado"));
    }

    @Override
    public DetalleVentas saveDetalleVentas(DetalleVentas detalleVentas) throws RuntimeException {
        return repo.save(detalleVentas);
    }

    @Override
    public DetalleVentas updateDetalleVentas(Integer id, DetalleVentas detalleVentas) {
        DetalleVentas existente = repo.findById(id).orElseThrow(() -> new RuntimeException("Detalle de Venta no encontrado"));

        existente.setCantidad(detalleVentas.getCantidad());
        existente.setPrecioUnitario(detalleVentas.getPrecioUnitario());
        existente.setSubtotal(detalleVentas.getSubtotal());
        existente.setProductosCodigoProducto(detalleVentas.getProductosCodigoProducto());
        existente.setVentasCodigoVenta(detalleVentas.getVentasCodigoVenta());

        return repo.save(existente);
    }

    @Override
    public void eliminar(int id) {
        repo.deleteById(id);
    }
}
