package com.estebanchun.ventas.Service;

import com.estebanchun.ventas.Entity.Usuarios;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UsuarioService {
    List<Usuarios> getAllUsuarios();
    Usuarios getUsuarioById(Integer id);
    Usuarios saveUsuario(Usuarios usuarios) throws RuntimeException;
    Usuarios updateUsuario(Integer id, Usuarios usuarios);
    void deleteUsuario (Integer id);
}
