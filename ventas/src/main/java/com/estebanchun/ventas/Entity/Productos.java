package com.estebanchun.ventas.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "Productos")
public class Productos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "codigo_producto")
    private Integer codigoProducto;

    @NotBlank(message = "El campo de texto no debe de estar vacios")
    @Column(name = "nombre_producto")
    private String nombreProducto;

    @NotNull(message = "Los campos no pueden estar vacios")
    @Positive(message = "El precio debe ser mayor a 0")
    @Column(name = "precio")
    private Double precio;

    @NotNull(message = "Los campos no pueden estar vacios")
    @Positive(message = "El precio debe ser mayor a 0")
    @Column(name = "stock")
    private Integer stock;

    @NotNull(message = "Los campos no pueden estar vacios")
    @Min(value = 0, message = "Para estado inactivo 0")
    @Max(value = 1, message = "Para estado activo 1")
    @Column(name = "estado")
    private Integer estado;

    public Integer getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(Integer codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }
}
