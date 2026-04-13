package com.estebanchun.ventas.Controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VistasController {

    private boolean validarSesion(HttpSession session){
        return session.getAttribute("usuarioLogueado") != null;
    }

    @GetMapping("/clientes")
    public String clientes(HttpSession session){
        if (!validarSesion(session)) return "redirect:/login";
        return "clientes";
    }

    @GetMapping("/productos")
    public String productos(HttpSession session){
        if (!validarSesion(session)) return "redirect:/login";
        return "productos";
    }

    @GetMapping("/usuarios")
    public String usuarios(HttpSession session){
        if (!validarSesion(session)) return "redirect:/login";
        return "usuarios";
    }

    @GetMapping("/ventas")
    public String ventas(HttpSession session){
        if (!validarSesion(session)) return "redirect:/login";
        return "ventas";
    }

    @GetMapping("/detalleVenta")
    public String detalle(HttpSession session){
        if (!validarSesion(session)) return "redirect:/login";
        return "detalleVenta";
    }
}
