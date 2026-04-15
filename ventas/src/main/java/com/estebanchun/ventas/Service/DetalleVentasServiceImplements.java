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
        return null;
    }

    @Override
    public DetalleVentas saveDetalleVentas(DetalleVentas detalleVentas) throws RuntimeException {
        return null;
    }

    @Override
    public DetalleVentas updateDetalleVentas(Integer id, DetalleVentas detalleVentas) {
        return null;
    }

    @Override
    public void deleteDetalleVentas(Integer id) {

    }


}
