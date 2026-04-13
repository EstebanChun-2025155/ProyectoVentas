package com.estebanchun.ventas.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table (name = "Usuarios")
public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "codigo_usuario")
    private Integer codigoUsuario;

    @NotBlank(message = "El campo de texto no debe de estar vacios")
    @Column(name = "username")
    private String username;

    @NotBlank(message = "El campo de texto no debe de estar vacios")
    @Column(name = "pasword")
    private String pasword;

    @NotBlank(message = "El campo de texto no debe de estar vacios")
    @Email(message = "Formato de email inválido")
    @Pattern(regexp = ".*@(gmail\\.com|yahoo\\.com|hotmail\\.com|outlook\\.com)$",
            message = "Solo se permiten correos de Gmail, Yahoo, Hotmail u Outlook")
    @Column(name = "email")
    private String email;

    @NotBlank(message = "El campo de texto no debe de estar vacios")
    @Column(name = "rol")
    private String rol;

    @NotNull(message = "Los campos no pueden estar vacios")
    @Min(value = 0, message = "Para estado inactivo 0")
    @Max(value = 1, message = "Para estado activo 1")
    @Column(name = "estado")
    private Integer estado;

    public Integer getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(Integer codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasword() {
        return pasword;
    }

    public void setPasword(String pasword) {
        this.pasword = pasword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }
}
