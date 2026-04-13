package com.estebanchun.ventas.Repository;

import com.estebanchun.ventas.Entity.Ventas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public interface VentasRepository extends JpaRepository<Ventas, Integer>{
    Boolean existsByFechaVentaAndTotalAndEstadoAndClientesDpiClienteAndUsuarioCodigoUsuario(
        Date fechaVenta,
        Integer total,
        Integer estado,
        Integer clientesDpiCliente,
        Integer usuarioCodigoUsuario
    );
}
