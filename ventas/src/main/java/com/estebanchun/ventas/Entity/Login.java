package com.estebanchun.ventas.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Username")
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "idUsuario")
    private Integer idUsuario;

    @Column(name = "usuario")
    private String usuario;

    @Column(name = "contrasena")
    private String password;

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
