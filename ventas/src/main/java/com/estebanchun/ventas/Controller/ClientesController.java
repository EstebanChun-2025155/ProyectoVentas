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

    @PostMapping("/eliminar/{id}")
    public String eliminar(@PathVariable int id) {
        clientesService.eliminar(id);
        return "redirect:/clientes";
    }

    @GetMapping("/clientes/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("cliente", new Clientes());
        return "formClientes";
    }

    @PostMapping("/clientes/guardar")
    public String guardar(@ModelAttribute Clientes cliente) {
        clientesService.saveClientes(cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/clientes/editar/{id}")
    public String editar(@PathVariable int id, Model model) {
        Clientes cliente = clientesService.getClientesById(id);
        model.addAttribute("cliente", cliente);
        return "formClientes";
    }

    @PostMapping("/clientes/actualizar/{id}")
    public String actualizar(@PathVariable int id, @ModelAttribute Clientes cliente) {
        clientesService.updateClientes(id, cliente);
        return "redirect:/clientes";
    }
}
