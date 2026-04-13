package com.estebanchun.ventas.Repository;

import com.estebanchun.ventas.Entity.DetalleVentas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleVentasRepository extends JpaRepository<DetalleVentas, Integer> {
    Boolean existsByCantidadAndPrecioUnitarioAndSubtotalAndProductosCodigoProductoAndVentasCodigoVenta(
         Integer cantidad,
         Double precioUnitario,
         Double subtotal,
         Integer productosCodigoProducto,
         Integer ventasCodigoVenta
    );
}
