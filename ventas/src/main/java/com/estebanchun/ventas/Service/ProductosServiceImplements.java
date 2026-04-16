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
         return repo.findById(id).orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    @Override
    public Productos saveProducto(Productos productos) throws RuntimeException {
        return repo.save(productos);
    }

    @Override
    public Productos updateProducto(Integer id, Productos productos) {
        Productos existente = repo.findById(id).orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        existente.setNombreProducto(productos.getNombreProducto());
        existente.setPrecio(productos.getPrecio());
        existente.setStock(productos.getStock());
        existente.setEstado(productos.getEstado());

        return repo.save(existente);
    }

    @Override
    public void eliminar(int id) {
        repo.deleteById(id);
    }
}
