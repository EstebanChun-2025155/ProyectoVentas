package com.estebanchun.ventas.Controller;

import com.estebanchun.ventas.Entity.Usuarios;
import com.estebanchun.ventas.Entity.Ventas;
import com.estebanchun.ventas.Service.VentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class VentasController {
    @Autowired
    private VentasService ventas;

    @GetMapping("/ventas")
    public String listarClientes(Model model) {
        List<Ventas> lista = ventas.listar();
        model.addAttribute("ventas", lista);

        return "ventas";
    }
}
