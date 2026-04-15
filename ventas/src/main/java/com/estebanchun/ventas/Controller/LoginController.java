package com.estebanchun.ventas.Controller;

import com.estebanchun.ventas.Entity.Login;
import com.estebanchun.ventas.Service.LoginService;
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
    private LoginService service;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String validar(@RequestParam String usuario,
                          @RequestParam String password,
                          Model model, HttpSession session) {

        Login u = service.login(usuario, password);

        if (u != null) {
            session.setAttribute("usuarioLogueado", u);
            return "redirect:/home";
        } else {
            model.addAttribute("error", "Credenciales incorrectas");
            return "login";
        }
    }
}
