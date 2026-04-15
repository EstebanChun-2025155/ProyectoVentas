package com.estebanchun.ventas.Service;

import com.estebanchun.ventas.Entity.Login;

import java.util.List;

public interface LoginService {
    Login registrar(String usuario, String password);
    Login login(String usuario, String password);
    List<Login> listar();
    void eliminar(int id);
}
