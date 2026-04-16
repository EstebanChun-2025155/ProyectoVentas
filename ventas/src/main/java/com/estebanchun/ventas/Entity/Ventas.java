package com.estebanchun.ventas.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

@Entity
@Table(name = "Ventas")
public class Ventas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "codigo_venta")
    private Integer codigoVenta;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "La fecha es obligatoria")
    @Column(name = "fecha_venta")
    private LocalDate fechaVenta;

    @NotNull(message = "Los campos no pueden estar vacios")
    @Positive(message = "El precio debe ser mayor a 0")
    @Column(name = "total")
    private Double  total;

    @NotNull(message = "Los campos no pueden estar vacios")
    @Min(value = 0, message = "Para estado inactivo 0")
    @Max(value = 1, message = "Para estado activo 1")
    @Column(name = "estado")
    private Integer estado;

    @NotNull(message = "Los campos no pueden estar vacios")
    @Positive(message = "El precio debe ser mayor a 0")
    @Column(name = "clientes_dpi_cliente")
    private Integer clientesDpiCliente;

    @NotNull(message = "Los campos no pueden estar vacios")
    @Positive(message = "El precio debe ser mayor a 0")
    @Column(name = "Usuario_codigo_usuario")
    private Integer usuarioCodigoUsuario;

    public Integer getCodigoVenta() {
        return codigoVenta;
    }

    public void setCodigoVenta(Integer codigoVenta) {
        this.codigoVenta = codigoVenta;
    }

    public LocalDate getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(LocalDate fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Integer getClientesDpiCliente() {
        return clientesDpiCliente;
    }

    public void setClientesDpiCliente(Integer clientesDpiCliente) {
        this.clientesDpiCliente = clientesDpiCliente;
    }

    public Integer getUsuarioCodigoUsuario() {
        return usuarioCodigoUsuario;
    }

    public void setUsuarioCodigoUsuario(Integer usuarioCodigoUsuario) {
        this.usuarioCodigoUsuario = usuarioCodigoUsuario;
    }
}
