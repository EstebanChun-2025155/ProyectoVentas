package com.estebanchun.ventas.Controller;

import com.estebanchun.ventas.Entity.Clientes;
import com.estebanchun.ventas.Service.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class ClientesController {
    @Autowired
    private ClientesService clientesService;

    @GetMapping("/clientes")
    public String listarClientes(Model model) {
        List<Clientes> lista = clientesService.listar();
        model.addAttribute("clientes", lista);

        return "clientes";
    }
}
