package com.estebanchun.ventas.Controller;

import com.estebanchun.ventas.Entity.Usuarios;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String mostrarHome(HttpSession session, Model model) {
        Usuarios usuario = (Usuarios) session.getAttribute("usuarioLogueado");

        if (usuario == null) {
            return "redirect:/login";
        }
        model.addAttribute("usuario", usuario);

        return "home";
    }


    @PostMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
