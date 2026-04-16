package com.estebanchun.ventas.Controller;

import com.estebanchun.ventas.Entity.Usuarios;
import com.estebanchun.ventas.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

@Controller
public class RegisterController {

    @Autowired
    private UsuarioService service;

    @GetMapping("/registro")
    public String registro(Model model) {
        model.addAttribute("usuario", new Usuarios());
        return "registro";
    }

    @PostMapping("/registro")
    public String guardar(@ModelAttribute Usuarios usuario, Model model) {

        usuario.setRol("USER");
        usuario.setEstado(1);

        Usuarios u = service.saveUsuario(usuario);

        if (u == null) {
            model.addAttribute("error", "Usuario ya existe");
            return "registro";
        }

        return "redirect:/login";
    }
}
