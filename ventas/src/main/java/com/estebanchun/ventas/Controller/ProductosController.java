package com.estebanchun.ventas.Controller;

import com.estebanchun.ventas.Entity.DetalleVentas;
import com.estebanchun.ventas.Entity.Productos;
import com.estebanchun.ventas.Service.DetalleVentasService;
import com.estebanchun.ventas.Service.ProductosService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductosController {
    @Autowired
    private ProductosService producto;

    @GetMapping("/productos")
    public String listarClientes(Model model) {
        List<Productos> lista = producto.listar();
        model.addAttribute("productos", lista);

        return "productos";
    }
}
