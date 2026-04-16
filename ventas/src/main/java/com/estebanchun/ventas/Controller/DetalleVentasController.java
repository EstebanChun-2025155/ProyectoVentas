package com.estebanchun.ventas.Controller;

import com.estebanchun.ventas.Entity.DetalleVentas;
import com.estebanchun.ventas.Service.DetalleVentasService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DetalleVentasController {
    private final DetalleVentasService detalleVentaService;

    public DetalleVentasController(DetalleVentasService detalleVentaService) {
        this.detalleVentaService = detalleVentaService;
    }

    @GetMapping("/detalleVenta")
    public String listarDetalleVentas(Model model) {
        List<DetalleVentas> lista = detalleVentaService.listar();
        model.addAttribute("detalleVenta", lista);

        return "detalleVenta";
    }

    @PostMapping("/detalleVenta/eliminar/{id}")
    public String eliminar(@PathVariable int id) {
        detalleVentaService.eliminar(id);
        return "redirect:/detalleVenta";
    }

    @GetMapping("/detalleVenta/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("detalleVenta", new DetalleVentas());
        return "formDetalleVenta";
    }

    @PostMapping("/detalleVenta/guardar")
    public String guardar(@ModelAttribute DetalleVentas detalleVentas) {
        detalleVentaService.saveDetalleVentas(detalleVentas);
        return "redirect:/detalleVenta";
    }

    @GetMapping("/detalleVenta/editar/{id}")
    public String editar(@PathVariable int id, Model model) {
        DetalleVentas detalleVentas = detalleVentaService.getDetalleVentasById(id);
        model.addAttribute("detalleVenta", detalleVentas);
        return "formDetalleVenta";
    }

    @PostMapping("/detalleVenta/actualizar/{id}")
    public String actualizar(@PathVariable int id, @ModelAttribute DetalleVentas detalleVentas) {
        detalleVentaService.updateDetalleVentas(id, detalleVentas);
        return "redirect:/detalleVenta";
    }
}
