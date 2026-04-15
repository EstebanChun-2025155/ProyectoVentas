package com.estebanchun.ventas.Service;

import com.estebanchun.ventas.Entity.Productos;
import com.estebanchun.ventas.Repository.ProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductosServiceImplements implements ProductosService{
    @Autowired
    private ProductosRepository repo;

    @Override
    public List<Productos> listar() {
        return repo.findAll();
    }

    @Override
    public Productos getProductosById(Integer id) {
        return null;
    }

    @Override
    public Productos saveProducto(Productos productos) throws RuntimeException {
        return null;
    }

    @Override
    public Productos updateProducto(Integer id, Productos productos) {
        return null;
    }

    @Override
    public void deleteProducto(Integer id) {

    }
}
