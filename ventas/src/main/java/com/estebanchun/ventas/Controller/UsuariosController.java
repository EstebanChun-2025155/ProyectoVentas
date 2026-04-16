package com.estebanchun.ventas.Controller;

import com.estebanchun.ventas.Entity.Usuarios;
import com.estebanchun.ventas.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UsuariosController {
    @Autowired
    private UsuarioService usuariosService;

    @GetMapping("/usuarios")
    public String listarUsuarios(Model model) {
        List<Usuarios> lista = usuariosService.listar();
        model.addAttribute("usuarios", lista);

        return "usuarios";
    }

    @PostMapping("/usuarios/eliminar/{id}")
    public String eliminar(@PathVariable int id) {
        usuariosService.eliminar(id);
        return "redirect:/usuarios";
    }

    @GetMapping("/usuarios/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("usuario", new Usuarios());
        return "formUsuarios";
    }

    @PostMapping("/usuarios/guardar")
    public String guardar(@ModelAttribute Usuarios usuario) {
        usuariosService.saveUsuario(usuario);
        return "redirect:/usuarios";
    }

    @GetMapping("/usuarios/editar/{id}")
    public String editar(@PathVariable int id, Model model) {
        Usuarios usuario  = usuariosService.getUsuarioById(id);
        model.addAttribute("usuario", usuario );
        return "formUsuarios";
    }

    @PostMapping("/usuarios/actualizar/{id}")
    public String actualizar(@PathVariable int id, @ModelAttribute Usuarios usuario ) {
        usuariosService.updateUsuario(id, usuario );
        return "redirect:/usuarios";
    }
}
