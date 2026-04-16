package com.estebanchun.ventas.Service;

import com.estebanchun.ventas.Entity.Clientes;
import com.estebanchun.ventas.Repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientesServiceImplements implements ClientesService {

    @Autowired
    private ClientesRepository repo;

    @Override
    public List<Clientes> listar() {
        return repo.findAll();
    }

    @Override
    public Clientes getClientesById(Integer id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    @Override
    public Clientes saveClientes(Clientes clientes) {
        return repo.save(clientes);
    }

    @Override
    public Clientes updateClientes(Integer id, Clientes clientes) {
        Clientes existente = repo.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        existente.setNombreCliente(clientes.getNombreCliente());
        existente.setApellidoCliente(clientes.getApellidoCliente());
        existente.setDireccion(clientes.getDireccion());
        existente.setEstado(clientes.getEstado());

        return repo.save(existente);
    }

    @Override
    public void eliminar(int id) {
        repo.deleteById(id);
    }
}
