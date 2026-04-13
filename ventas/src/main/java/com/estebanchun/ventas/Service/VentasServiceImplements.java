package com.estebanchun.ventas.Service;

import com.estebanchun.ventas.Entity.Ventas;
import com.estebanchun.ventas.Repository.VentasRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentasServiceImplements implements VentasService{
    private final VentasRepository ventasRepository;

    public VentasServiceImplements(VentasRepository ventasRepository) {
        this.ventasRepository = ventasRepository;
    }

    @Override
    public List<Ventas> getallVentas() {
        return ventasRepository.findAll();
    }

    @Override
    public Ventas getVentasById(Integer id) {
        Ventas ventas = ventasRepository.findById(id).orElse(null);
        if(ventas == null) {
            throw new RuntimeException("La venta no se encontro");
        }
        return ventasRepository.findById(id).orElse(null);
    }

    @Override
    public Ventas saveVentas(Ventas ventas) throws RuntimeException {
        try {
            if (ventasRepository.existsByFechaVentaAndTotalAndEstadoAndClientesDpiClienteAndUsuarioCodigoUsuario(
                    ventas.getFechaVenta(),
                    ventas.getTotal(),
                    ventas.getEstado(),
                    ventas.getClientesDpiCliente(),
                    ventas.getUsuarioCodigoUsuario())){
                throw new RuntimeException("Ya existe una venta con esos datos");
            }
            return ventasRepository.save(ventas);
        } catch (RuntimeException e) {
            throw new  RuntimeException(e.getMessage());
        }
    }

    @Override
    public Ventas updateVentas(Integer id, Ventas ventas) {
        Ventas existingVentas = ventasRepository.findById(id).orElseThrow(() -> new RuntimeException("La venta no existe"));

        if (ventasRepository.existsByFechaVentaAndTotalAndEstadoAndClientesDpiClienteAndUsuarioCodigoUsuario(
                ventas.getFechaVenta(),
                ventas.getTotal(),
                ventas.getEstado(),
                ventas.getClientesDpiCliente(),
                ventas.getUsuarioCodigoUsuario())){
            throw new RuntimeException("Ya existe una venta con esos datos");
        }

        existingVentas.setFechaVenta(ventas.getFechaVenta());
        existingVentas.setTotal(ventas.getTotal());
        existingVentas.setEstado(ventas.getEstado());
        existingVentas.setClientesDpiCliente(ventas.getClientesDpiCliente());
        existingVentas.setUsuarioCodigoUsuario(ventas.getUsuarioCodigoUsuario());

        return ventasRepository.save(existingVentas);
    }

    @Override
    public void delteVentas(Integer id) {
        if(!ventasRepository.existsById(id)){
            throw new RuntimeException("Este id no existe");
        }
        ventasRepository.deleteById(id);
    }
}
