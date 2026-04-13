package com.estebanchun.ventas.Service;

import com.estebanchun.ventas.Entity.DetalleVentas;
import com.estebanchun.ventas.Repository.DetalleVentasRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleVentasServiceImplements implements DetalleVentasService {
    private final DetalleVentasRepository detalleVentasRepository;

    public DetalleVentasServiceImplements(DetalleVentasRepository detalleVentasRepository) {
        this.detalleVentasRepository = detalleVentasRepository;
    }

    @Override
    public List<DetalleVentas> getAllDetalleVentas() {
        return detalleVentasRepository.findAll();
    }

    @Override
    public DetalleVentas getDetalleVentasById(Integer id) {
        DetalleVentas detalleVentas = detalleVentasRepository.findById(id).orElse(null);
        if(detalleVentas == null) {
            throw new RuntimeException("El registro de esta venta no se encontro");
        }
        return detalleVentasRepository.findById(id).orElse(null);
    }

    @Override
    public DetalleVentas saveDetalleVentas(DetalleVentas detalleVentas) throws RuntimeException {
        try {
            if (detalleVentasRepository.existsByCantidadAndPrecioUnitarioAndSubtotalAndProductosCodigoProductoAndVentasCodigoVenta(
                    detalleVentas.getCantidad(),
                    detalleVentas.getPrecioUnitario(),
                    detalleVentas.getSubtotal(),
                    detalleVentas.getProductosCodigoProducto(),
                    detalleVentas.getVentasCodigoVenta())){
                throw new RuntimeException("Ya existe un registro de venta con esos datos");
            }
            return detalleVentasRepository.save(detalleVentas);
        } catch (RuntimeException e) {
            throw new  RuntimeException(e.getMessage());
        }
    }

    @Override
    public DetalleVentas updateDetalleVentas(Integer id, DetalleVentas detalleVentas) {
        DetalleVentas existingDetalleVentas = detalleVentasRepository.findById(id).orElseThrow(() -> new RuntimeException("El registro de venta no existe"));

        if (detalleVentasRepository.existsByCantidadAndPrecioUnitarioAndSubtotalAndProductosCodigoProductoAndVentasCodigoVenta(
                detalleVentas.getCantidad(),
                detalleVentas.getPrecioUnitario(),
                detalleVentas.getSubtotal(),
                detalleVentas.getProductosCodigoProducto(),
                detalleVentas.getVentasCodigoVenta())){
            throw new RuntimeException("Ya existe un registro de venta con esos datos");
        }

        existingDetalleVentas.setCantidad(detalleVentas.getCantidad());
        existingDetalleVentas.setPrecioUnitario(detalleVentas.getPrecioUnitario());
        existingDetalleVentas.setSubtotal(detalleVentas.getSubtotal());
        existingDetalleVentas.setProductosCodigoProducto(detalleVentas.getProductosCodigoProducto());
        existingDetalleVentas.setVentasCodigoVenta(detalleVentas.getVentasCodigoVenta());

        return detalleVentasRepository.save(existingDetalleVentas);

    }

    @Override
    public void deleteDetalleVentas(Integer id) {
        if(!detalleVentasRepository.existsById(id)){
            throw new RuntimeException("Este id no existe");
        }
        detalleVentasRepository.deleteById(id);
    }
}
