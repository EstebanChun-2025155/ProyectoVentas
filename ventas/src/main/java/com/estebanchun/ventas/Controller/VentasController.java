package com.estebanchun.ventas.Controller;

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
    private VentasService ventasService;

    @GetMapping("/ventas")
    public String listarVentas(Model model) {
        List<Ventas> lista = ventasService.listar();
        model.addAttribute("ventas", lista);

        return "ventas";
    }

    @PostMapping("/ventas/eliminar/{id}")
    public String eliminar(@PathVariable int id) {
        ventasService.eliminar(id);
        return "redirect:/ventas";
    }

    @GetMapping("/ventas/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("venta", new Ventas());
        return "formVentas";
    }

    @PostMapping("/ventas/guardar")
    public String guardar(@ModelAttribute Ventas venta) {
        ventasService.saveVentas(venta);
        return "redirect:/ventas";
    }

    @GetMapping("/ventas/editar/{id}")
    public String editar(@PathVariable int id, Model model) {
        Ventas venta  = ventasService.getVentasById(id);
        model.addAttribute("venta", venta);
        return "formVentas";
    }

    @PostMapping("/ventas/actualizar/{id}")
    public String actualizar(@PathVariable int id, @ModelAttribute Ventas venta) {
        ventasService.updateVentas(id, venta);
        return "redirect:/ventas";
    }
}
