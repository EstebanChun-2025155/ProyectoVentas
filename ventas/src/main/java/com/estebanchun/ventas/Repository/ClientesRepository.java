package com.estebanchun.ventas.Repository;

import com.estebanchun.ventas.Entity.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientesRepository extends JpaRepository<Clientes, Integer> {
    Boolean existsByNombreClienteAndApellidoClienteAndDireccionAndEstado(
        String nombreCliente,
        String apellidoCliente,
        String direccion,
        Integer estado
    );
}
