package com.estebanchun.ventas.Service;

import com.estebanchun.ventas.Entity.Clientes;
import com.estebanchun.ventas.Repository.ClientesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientesServiceImplements implements ClientesService {
    private final ClientesRepository clientesRepository;

    public ClientesServiceImplements(ClientesRepository clientesRepository) {
        this.clientesRepository = clientesRepository;
    }

    @Override
    public List<Clientes> getAllClientes() {
        return clientesRepository.findAll();
    }

    @Override
    public Clientes getClientesById(Integer id) {
        Clientes clientes = clientesRepository.findById(id).orElse(null);
        if(clientes == null) {
            throw new RuntimeException("Cliente no encontrado");
        }
        return clientesRepository.findById(id).orElse(null);
    }

    @Override
    public Clientes saveClientes(Clientes clientes) throws RuntimeException {
        try {
            if (clientesRepository.existsByNombreClienteAndApellidoClienteAndDireccionAndEstado(
                    clientes.getNombreCliente(),
                    clientes.getApellidoCliente(),
                    clientes.getDireccion(),
                    clientes.getEstado())){
                throw new RuntimeException("Ya existe un cliente con esos datos");
            }
            return clientesRepository.save(clientes);
        } catch (RuntimeException e) {
            throw new  RuntimeException(e.getMessage());
        }
    }

    @Override
    public Clientes updateClientes(Integer id, Clientes clientes) {
        Clientes existingClientes = clientesRepository.findById(id).orElseThrow(() -> new RuntimeException("El cliente no existe"));

        if (clientesRepository.existsByNombreClienteAndApellidoClienteAndDireccionAndEstado(
                clientes.getNombreCliente(),
                clientes.getApellidoCliente(),
                clientes.getDireccion(),
                clientes.getEstado())){
            throw new RuntimeException("Ya existe un cliente con esos datos");
        }

        existingClientes.setNombreCliente(clientes.getNombreCliente());
        existingClientes.setApellidoCliente(clientes.getApellidoCliente());
        existingClientes.setDireccion(clientes.getDireccion());
        existingClientes.setEstado(clientes.getEstado());

        return clientesRepository.save(existingClientes);
    }

    @Override
    public void deleteClientes(Integer id) {
        if(!clientesRepository.existsById(id)){
            throw new RuntimeException("Este id no existe");
        }
        clientesRepository.deleteById(id);
    }
}
