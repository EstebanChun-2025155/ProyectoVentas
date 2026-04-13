package com.estebanchun.ventas.Controller;

import com.estebanchun.ventas.Entity.Clientes;
import com.estebanchun.ventas.Service.ClientesService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Clientes")
public class ClientesController {
    private final ClientesService clientesService;

    public ClientesController(ClientesService clientesService) {
        this.clientesService = clientesService;
    }

    @GetMapping
    public List<Clientes> getAllClientes(){ return clientesService.getAllClientes(); }

    @PostMapping
    public ResponseEntity<Object> createClientes(@Valid @RequestBody Clientes clientes, BindingResult br){
        if (br.hasErrors()){
            return ResponseEntity.badRequest().body(br.getAllErrors().get(0).getDefaultMessage());
        }

        try {
            Clientes createCasa = clientesService.saveClientes(clientes);
            return new ResponseEntity<>(createCasa, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getClientesById(@PathVariable Integer id){
        try {
            Clientes buscarId = clientesService.getClientesById(id);
            return ResponseEntity.status(404).body("No existe este Cliente");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Error al buscar al Cliente");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteClientes(@PathVariable Integer id){
        try {
            if(clientesService.getClientesById(id) == null) {
                return ResponseEntity.status(404).body("No exsite este Cliente");
            }
            clientesService.deleteClientes(id);
            return ResponseEntity.status(202).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al eliminar el Cliente");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateClientes(@PathVariable Integer id, @Valid @RequestBody Clientes clientes, BindingResult br){
        if (br.hasErrors()){
            return ResponseEntity.badRequest().body(br.getAllErrors().get(0).getDefaultMessage());
        }
        try {
            Clientes actualizado = clientesService.updateClientes(id, clientes);
            return ResponseEntity.ok(actualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
