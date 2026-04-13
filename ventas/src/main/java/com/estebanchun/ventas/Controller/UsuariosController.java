package com.estebanchun.ventas.Controller;

import com.estebanchun.ventas.Entity.Usuarios;
import com.estebanchun.ventas.Service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Usuarios")
public class UsuariosController {
    private final UsuarioService usuarioService;

    public UsuariosController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<Usuarios> getAllUsuarios(){ return usuarioService.getAllUsuarios(); }

    @PostMapping
    public ResponseEntity<Object> createUsuarios(@Valid @RequestBody Usuarios usuarios, BindingResult br){
        if (br.hasErrors()){
            return ResponseEntity.badRequest().body(br.getAllErrors().get(0).getDefaultMessage());
        }

        try {
            Usuarios createUsuarios = usuarioService.saveUsuario(usuarios);
            return new ResponseEntity<>(createUsuarios, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUsuarioById(@PathVariable Integer id){
        try {
            Usuarios buscarId = usuarioService.getUsuarioById(id);
            return ResponseEntity.status(404).body("No existe este Usuario");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Error al buscar el Usuario");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUsuario(@PathVariable Integer id){
        try {
            if(usuarioService.getUsuarioById(id) == null) {
                return ResponseEntity.status(404).body("No exsite este Usuario");
            }
            usuarioService.deleteUsuario(id);
            return ResponseEntity.status(202).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al eliminar el Usuario");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateDetalleVentas(@PathVariable Integer id, @Valid @RequestBody Usuarios usuarios, BindingResult br){
        if (br.hasErrors()){
            return ResponseEntity.badRequest().body(br.getAllErrors().get(0).getDefaultMessage());
        }
        try {
            Usuarios actualizado = usuarioService.updateUsuario(id, usuarios);
            return ResponseEntity.ok(actualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
