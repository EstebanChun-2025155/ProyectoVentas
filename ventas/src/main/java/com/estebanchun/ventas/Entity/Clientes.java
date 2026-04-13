package com.estebanchun.ventas.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Clientes")
public class Clientes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "dpi_cliente")
    private Integer dpiCliente;

    @NotBlank(message = "El campo de texto no debe de estar vacios")
    @Column(name = "nombre_cliente")
    private String nombreCliente;

    @NotBlank(message = "El campo de texto no debe de estar vacios")
    @Column(name = "apellido_cliente")
    private String apellidoCliente;

    @NotBlank(message = "El campo de texto no debe de estar vacios")
    @Column(name = "direccion")
    private String direccion;

    @NotNull(message = "Los campos no pueden estar vacios")
    @Min(value = 0, message = "Para estado inactivo 0")
    @Max(value = 1, message = "Para estado activo 1")
    @Column(name = "estado")
    private Integer estado;

    public Integer getDpiCliente() {
        return dpiCliente;
    }

    public void setDpiCliente(Integer dpiCliente) {
        this.dpiCliente = dpiCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }
}
