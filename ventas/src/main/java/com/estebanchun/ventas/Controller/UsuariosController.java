package com.estebanchun.ventas.Controller;

import com.estebanchun.ventas.Entity.Usuarios;
import com.estebanchun.ventas.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UsuariosController {
    @Autowired
    private UsuarioService usuarios;

    @GetMapping("/usuarios")
    public String listarClientes(Model model) {
        List<Usuarios> lista = usuarios.listar();
        model.addAttribute("usuarios", lista);

        return "usuarios";
    }
}
