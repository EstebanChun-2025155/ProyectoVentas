package com.estebanchun.ventas.Repository;

import com.estebanchun.ventas.Entity.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Integer> {
    Boolean existsByUsernameAndPaswordAndEmailAndRolAndEstado(
        String username,
        String pasword,
        String email,
        String rol,
        Integer estado
    );
}
