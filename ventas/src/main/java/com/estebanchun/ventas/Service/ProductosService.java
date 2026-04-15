package com.estebanchun.ventas.Service;

import com.estebanchun.ventas.Entity.Productos;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductosService {
    List<Productos> listar();
    Productos getProductosById(Integer id);
    Productos saveProducto(Productos productos) throws RuntimeException;
    Productos updateProducto(Integer id, Productos productos);
    void deleteProducto (Integer id);
}
