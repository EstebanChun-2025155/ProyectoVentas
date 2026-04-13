package com.estebanchun.ventas.Controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @GetMapping("/")
    public String inicio(){
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String mostrarLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password,
                        HttpSession session, Model model){

        String userCorrecto = "Ventas";
        String passCorrecto = "1234";

        if (username.equals(userCorrecto) && password.equals(passCorrecto)){
            session.setAttribute("usuarioLogueado", username);
            return "redirect:/home";
        }else {
            model.addAttribute("error", "usuario y contrasena incorrecta");
            return "login";
        }
    }

}
