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
        return null;
    }

    @Override
    public Ventas saveVentas(Ventas ventas) throws RuntimeException {
        return null;
    }

    @Override
    public Ventas updateVentas(Integer id, Ventas ventas) {
        return null;
    }

    @Override
    public void delteVentas(Integer id) {

    }
}
