package com.estebanchun.ventas.Controller;

import com.estebanchun.ventas.Entity.DetalleVentas;
import com.estebanchun.ventas.Service.DetalleVentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DetalleVentasController {
    @Autowired
    private DetalleVentasService detalleVenta;

    @GetMapping("/detalleVenta")
    public String listarClientes(Model model) {
        List<DetalleVentas> lista = detalleVenta.listar();
        model.addAttribute("detalleVenta", lista);

        return "detalleVenta";
    }

}
