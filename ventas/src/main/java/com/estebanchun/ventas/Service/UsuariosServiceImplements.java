package com.estebanchun.ventas.Service;

import com.estebanchun.ventas.Entity.Usuarios;
import com.estebanchun.ventas.Repository.UsuariosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuariosServiceImplements implements UsuarioService{
    private final UsuariosRepository usuariosRepository;

    public UsuariosServiceImplements(UsuariosRepository usuariosRepository) {
        this.usuariosRepository = usuariosRepository;
    }

    @Override
    public List<Usuarios> getAllUsuarios() {
        return usuariosRepository.findAll();
    }

    @Override
    public Usuarios getUsuarioById(Integer id) {
        Usuarios usuarios = usuariosRepository.findById(id).orElse(null);
        if(usuarios == null) {
            throw new RuntimeException("El producto no se encontro");
        }
        return usuariosRepository.findById(id).orElse(null);
    }

    @Override
    public Usuarios saveUsuario(Usuarios usuarios) throws RuntimeException {
        try {
            if (usuariosRepository.existsByUsernameAndPaswordAndEmailAndRolAndEstado(
                    usuarios.getUsername(),
                    usuarios.getPasword(),
                    usuarios.getEmail(),
                    usuarios.getRol(),
                    usuarios.getEstado())){
                throw new RuntimeException("Ya existe un Usuario con esos datos");
            }
            return usuariosRepository.save(usuarios);
        } catch (RuntimeException e) {
            throw new  RuntimeException(e.getMessage());
        }
    }

    @Override
    public Usuarios updateUsuario(Integer id, Usuarios usuarios) {
        Usuarios existingUsuario = usuariosRepository.findById(id).orElseThrow(() -> new RuntimeException("El Usuario no existe"));

        if (usuariosRepository.existsByUsernameAndPaswordAndEmailAndRolAndEstado(
                usuarios.getUsername(),
                usuarios.getPasword(),
                usuarios.getEmail(),
                usuarios.getRol(),
                usuarios.getEstado())){
            throw new RuntimeException("Ya existe un Usuario con esos datos");
        }

        existingUsuario.setUsername(usuarios.getUsername());
        existingUsuario.setPasword(usuarios.getPasword());
        existingUsuario.setEmail(usuarios.getEmail());
        existingUsuario.setRol(usuarios.getRol());
        existingUsuario.setEstado(usuarios.getEstado());

        return usuariosRepository.save(existingUsuario);
    }

    @Override
    public void deleteUsuario(Integer id) {
        if(!usuariosRepository.existsById(id)){
            throw new RuntimeException("Este id no existe");
        }
        usuariosRepository.deleteById(id);
    }
}
