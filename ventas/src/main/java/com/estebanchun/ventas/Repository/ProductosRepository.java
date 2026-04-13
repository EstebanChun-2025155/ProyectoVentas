package com.estebanchun.ventas.Repository;

import com.estebanchun.ventas.Entity.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductosRepository extends JpaRepository<Productos, Integer> {
    Boolean existsByNombreProductoAndPrecioAndStockAndEstado(
        String nombreProducto,
        Double precio,
        Integer stock,
        Integer estado
    );
}
