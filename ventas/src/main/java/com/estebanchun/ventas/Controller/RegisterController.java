package com.estebanchun.ventas.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegisterController {
    @GetMapping("/registro")
    public String mostrarRegister() {
        return "registro";
    }

    @PostMapping("/registro")
    public String procesarRegister(
            @RequestParam String username,
            @RequestParam String password,
            Model model
    ) {

        if (username.isEmpty() || password.isEmpty()) {
            model.addAttribute("error", "Todos los campos son obligatorios");
            return "registro";
        }

        if (username.equals("Ventas")) {
            model.addAttribute("error", "El usuario ya existe");
            return "registro";
        }

        return "redirect:/login";
    }
}
