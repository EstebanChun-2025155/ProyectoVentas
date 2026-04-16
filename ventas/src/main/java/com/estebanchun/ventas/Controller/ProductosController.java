package com.estebanchun.ventas.Controller;

import com.estebanchun.ventas.Entity.Productos;
import com.estebanchun.ventas.Service.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductosController {
    @Autowired
    private ProductosService productosService;

    @GetMapping("/productos")
    public String listarProductos(Model model) {
        List<Productos> lista = productosService.listar();
        model.addAttribute("productos", lista);

        return "productos";
    }

    @PostMapping("/productos/eliminar/{id}")
    public String eliminar(@PathVariable int id) {
        productosService.eliminar(id);
        return "redirect:/productos";
    }

    @GetMapping("/productos/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("producto", new Productos());
        return "formProductos";
    }

    @PostMapping("/productos/guardar")
    public String guardar(@ModelAttribute Productos productos) {
        productosService.saveProducto(productos);
        return "redirect:/productos";
    }

    @GetMapping("/productos/editar/{id}")
    public String editar(@PathVariable int id, Model model) {
        Productos productos = productosService.getProductosById(id);
        model.addAttribute("producto", productos);
        return "formProductos";
    }

    @PostMapping("/productos/actualizar/{id}")
    public String actualizar(@PathVariable int id, @ModelAttribute Productos productos) {
        productosService.updateProducto(id, productos);
        return "redirect:/productos";
    }
}
