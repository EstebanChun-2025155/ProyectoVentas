package com.estebanchun.ventas.Service;

import com.estebanchun.ventas.Entity.Ventas;
import com.estebanchun.ventas.Repository.VentasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentasServiceImplements implements VentasService{
    @Autowired
    private VentasRepository repo;

    @Override
    public List<Ventas> listar() {
        return repo.findAll();
    }

    @Override
    public Ventas getVentasById(Integer id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Venta no encontrado"));
    }

    @Override
    public Ventas saveVentas(Ventas ventas) throws RuntimeException {
        return repo.save(ventas);
    }

    @Override
    public Ventas updateVentas(Integer id, Ventas ventas) {
        Ventas existente = repo.findById(id).orElseThrow(() -> new RuntimeException("Venta no encontrado"));

        existente.setFechaVenta(ventas.getFechaVenta());
        existente.setTotal(ventas.getTotal());
        existente.setClientesDpiCliente(ventas.getClientesDpiCliente());
        existente.setUsuarioCodigoUsuario(ventas.getUsuarioCodigoUsuario());

        return repo.save(existente);
    }

    @Override
    public void eliminar(int id) {
        repo.deleteById(id);
    }
}
