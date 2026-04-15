package com.estebanchun.ventas.Controller;

import com.estebanchun.ventas.Entity.Clientes;
import com.estebanchun.ventas.Entity.Login;
import com.estebanchun.ventas.Service.ClientesService;
import com.estebanchun.ventas.Service.LoginService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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
