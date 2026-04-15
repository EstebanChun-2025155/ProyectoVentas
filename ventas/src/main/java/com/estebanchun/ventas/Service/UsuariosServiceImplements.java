package com.estebanchun.ventas.Service;

import com.estebanchun.ventas.Entity.Usuarios;
import com.estebanchun.ventas.Repository.ProductosRepository;
import com.estebanchun.ventas.Repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuariosServiceImplements implements UsuarioService{
    @Autowired
    private UsuariosRepository repo;

    @Override
    public List<Usuarios> listar() {
        return repo.findAll();
    }

    @Override
    public Usuarios getUsuarioById(Integer id) {
        return null;
    }

    @Override
    public Usuarios saveUsuario(Usuarios usuarios) throws RuntimeException {
        return null;
    }

    @Override
    public Usuarios updateUsuario(Integer id, Usuarios usuarios) {
        return null;
    }

    @Override
    public void deleteUsuario(Integer id) {

    }
}
