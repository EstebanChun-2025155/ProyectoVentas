package com.estebanchun.ventas.Service;

import com.estebanchun.ventas.Entity.Usuarios;
import com.estebanchun.ventas.Repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuariosServiceImplements implements UsuarioService{
    @Autowired
    private UsuariosRepository repo;

    @Override
    public List<Usuarios> listar() {return repo.findAll();}

    @Override
    public Usuarios getUsuarioById(Integer id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    @Override
    public Usuarios saveUsuario(Usuarios usuarios) {

        if (repo.existsByUsername(usuarios.getUsername())) {
            return null;
        }

        if (usuarios.getRol().equalsIgnoreCase("ADMIN")) {
            long cantidadAdmins = repo.countByRol("ADMIN");
            if (cantidadAdmins >= 1) {
                throw new RuntimeException("Ya existe un administrador");
            }
        }

        return repo.save(usuarios);
    }

    @Override
    public Usuarios updateUsuario(Integer id, Usuarios usuarios) {
        Usuarios existente = repo.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        existente.setUsername(usuarios.getUsername());
        existente.setPasword(usuarios.getPasword());
        existente.setEmail(usuarios.getEmail());
        existente.setRol(usuarios.getRol());

        if(usuarios.getPasword() != null && !usuarios.getPasword().isEmpty()){
            existente.setPasword(usuarios.getPasword());
        }

        return repo.save(existente);
    }

    @Override
    public void eliminar(int id) {
        repo.deleteById(id);
    }

    @Override
    public Usuarios login(String username, String pasword) {
        return repo.findByUsernameAndPasword(username, pasword);
    }
}
