package com.estebanchun.ventas.Service;

import com.estebanchun.ventas.Entity.Login;
import com.estebanchun.ventas.Repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImplements implements LoginService{
    @Autowired
    private LoginRepository repo;

    @Override
    public Login registrar(String usuario, String password) {

        if (usuario.trim().isEmpty() || password.trim().isEmpty()) return null;

        usuario = usuario.trim().toLowerCase();
        password = password.trim();

        if (repo.findByUsuario(usuario) != null) {
            return null;
        }

        Login u = new Login();
        u.setUsuario(usuario);
        u.setPassword(password);

        return repo.save(u);
    }

    @Override
    public Login login(String usuario, String password) {

        if (usuario.trim().isEmpty() || password.trim().isEmpty()) return null;

        usuario = usuario.trim().toLowerCase();
        password = password.trim();

        Login u = repo.findByUsuario(usuario);

        if (u != null && u.getPassword().equals(password)) {
            return u;
        }

        return null;
    }

    @Override
    public List<Login> listar() {
        return repo.findAll();
    }

    @Override
    public void eliminar(int id) {
        repo.deleteById(id);
    }
}
