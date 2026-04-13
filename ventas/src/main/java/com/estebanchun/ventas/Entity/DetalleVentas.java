package com.estebanchun.ventas.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "DetalleVenta")
public class DetalleVentas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "codigo_detalle_venta")
    private Integer codigoDetalleVenta;

    @NotNull(message = "Los campos no pueden estar vacios")
    @Positive(message = "El precio debe ser mayor a 0")
    @Column(name = "cantidad")
    private Integer cantidad;

    @NotNull(message = "Los campos no pueden estar vacios")
    @Positive(message = "El precio debe ser mayor a 0")
    @Column(name = "precio_unitario")
    private Double precioUnitario;

    @NotNull(message = "Los campos no pueden estar vacios")
    @Positive(message = "El precio debe ser mayor a 0")
    @Column(name = "subtotal")
    private Double subtotal;

    @NotNull(message = "Los campos no pueden estar vacios")
    @Positive(message = "El precio debe ser mayor a 0")
    @Column(name = "productos_codigo_producto")
    private Integer productosCodigoProducto;

    @NotNull(message = "Los campos no pueden estar vacios")
    @Positive(message = "El precio debe ser mayor a 0")
    @Column(name = "ventas_codigo_venta")
    private Integer ventasCodigoVenta;

    public Integer getCodigoDetalleVenta() {
        return codigoDetalleVenta;
    }

    public void setCodigoDetalleVenta(Integer codigoDetalleVenta) {
        this.codigoDetalleVenta = codigoDetalleVenta;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Integer getProductosCodigoProducto() {
        return productosCodigoProducto;
    }

    public void setProductosCodigoProducto(Integer productosCodigoProducto) {
        this.productosCodigoProducto = productosCodigoProducto;
    }

    public Integer getVentasCodigoVenta() {
        return ventasCodigoVenta;
    }

    public void setVentasCodigoVenta(Integer ventasCodigoVenta) {
        this.ventasCodigoVenta = ventasCodigoVenta;
    }
}
