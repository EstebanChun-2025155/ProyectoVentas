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
        return null;
    }

    @Override
    public Clientes saveClientes(Clientes clientes) throws RuntimeException {
        return null;
    }

    @Override
    public Clientes updateClientes(Integer id, Clientes clientes) {
        return null;
    }

    @Override
    public void eliminar(int id) {
        repo.deleteById(id);
    }
}
