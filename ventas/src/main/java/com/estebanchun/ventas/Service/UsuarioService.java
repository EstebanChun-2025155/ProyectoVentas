package com.estebanchun.ventas.Service;

import com.estebanchun.ventas.Entity.Usuarios;

import java.util.List;

public interface UsuarioService {
    List<Usuarios> listar();
    Usuarios getUsuarioById(Integer id);
    Usuarios saveUsuario(Usuarios usuarios) throws RuntimeException;
    Usuarios updateUsuario(Integer id, Usuarios usuarios);
    void eliminar(int id);
    Usuarios login(String username, String pasword);
}
