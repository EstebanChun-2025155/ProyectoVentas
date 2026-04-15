package com.estebanchun.ventas.Repository;

import com.estebanchun.ventas.Entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login, Integer> {
    Login findByUsuario(String usuario);
}
