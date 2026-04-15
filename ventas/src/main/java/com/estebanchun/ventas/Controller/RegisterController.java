package com.estebanchun.ventas.Controller;

import com.estebanchun.ventas.Entity.Login;
import com.estebanchun.ventas.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegisterController {

    @Autowired
    private LoginService service;

    @GetMapping("/registro")
    public String registro() {
        return "registro";
    }

    @PostMapping("/registro")
    public String guardar(@RequestParam String usuario,
                          @RequestParam String password,
                          Model model) {

        Login u = service.registrar(usuario, password);

        if (u == null) {
            model.addAttribute("error", "Usuario ya existe");
            return "registro";
        }

        return "redirect:/login";
    }
}
