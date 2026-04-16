package com.estebanchun.ventas.Controller;

import com.estebanchun.ventas.Entity.Usuarios;
import com.estebanchun.ventas.Service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @Autowired
    private UsuarioService service;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String validar(@RequestParam String usuario,
                          @RequestParam String password,
                          Model model, HttpSession session) {

        Usuarios u = service.login(usuario, password);

        if (u != null && u.getEstado() == 1) {

            session.setAttribute("usuarioLogueado", u);

            return "redirect:/home";

        } else {
            model.addAttribute("error", "Credenciales incorrectas");
            return "login";
        }
    }
}
