package com.estebanchun.ventas.Service;

import com.estebanchun.ventas.Entity.Productos;
import com.estebanchun.ventas.Repository.ProductosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductosServiceImplements implements ProductosService{
    private final ProductosRepository productosRepository;

    public ProductosServiceImplements(ProductosRepository productosRepository) {
        this.productosRepository = productosRepository;
    }

    @Override
    public List<Productos> getAllProductos() {
        return productosRepository.findAll();
    }

    @Override
    public Productos getProductosById(Integer id) {
        Productos productos = productosRepository.findById(id).orElse(null);
        if(productos == null) {
            throw new RuntimeException("El producto no se encontro");
        }
        return productosRepository.findById(id).orElse(null);
    }

    @Override
    public Productos saveProducto(Productos productos) throws RuntimeException {
        try {
            if (productosRepository.existsByNombreProductoAndPrecioAndStockAndEstado(
                    productos.getNombreProducto(),
                    productos.getPrecio(),
                    productos.getStock(),
                    productos.getEstado())){
                throw new RuntimeException("Ya existe un producto con esos datos");
            }
            return productosRepository.save(productos);
        } catch (RuntimeException e) {
            throw new  RuntimeException(e.getMessage());
        }
    }

    @Override
    public Productos updateProducto(Integer id, Productos productos) {
        Productos existingProductos = productosRepository.findById(id).orElseThrow(() -> new RuntimeException("El producto no existe"));

        if (productosRepository.existsByNombreProductoAndPrecioAndStockAndEstado(
                productos.getNombreProducto(),
                productos.getPrecio(),
                productos.getStock(),
                productos.getEstado())){
            throw new RuntimeException("Ya existe un producto con esos datos");
        }

        existingProductos.setNombreProducto(productos.getNombreProducto());
        existingProductos.setPrecio(productos.getPrecio());
        existingProductos.setStock(productos.getStock());
        existingProductos.setEstado(productos.getEstado());

        return productosRepository.save(existingProductos);

    }

    @Override
    public void deleteProducto(Integer id) {
        if(!productosRepository.existsById(id)){
            throw new RuntimeException("Este id no existe");
        }
        productosRepository.deleteById(id);
    }
}
