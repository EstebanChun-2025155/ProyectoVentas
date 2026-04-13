package com.estebanchun.ventas.Controller;

import com.estebanchun.ventas.Entity.Ventas;
import com.estebanchun.ventas.Service.VentasService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Ventas")
public class VentasController {
    private final VentasService ventasService;

    public VentasController(VentasService ventasService) {
        this.ventasService = ventasService;
    }

    @GetMapping
    public List<Ventas> getAllVentas(){ return ventasService.getallVentas(); }

    @PostMapping
    public ResponseEntity<Object> createVentas(@Valid @RequestBody Ventas ventas, BindingResult br){
        if (br.hasErrors()){
            return ResponseEntity.badRequest().body(br.getAllErrors().get(0).getDefaultMessage());
        }

        try {
            Ventas createVentas = ventasService.saveVentas(ventas);
            return new ResponseEntity<>(createVentas, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getVentasById(@PathVariable Integer id){
        try {
            Ventas buscarId = ventasService.getVentasById(id);
            return ResponseEntity.status(404).body("No existe esta Venta");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Error al buscar la Venta");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteVentas(@PathVariable Integer id){
        try {
            if(ventasService.getVentasById(id) == null) {
                return ResponseEntity.status(404).body("No exsite esta Venta");
            }
            ventasService.delteVentas(id);
            return ResponseEntity.status(202).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al eliminar la Venta");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateVentas(@PathVariable Integer id, @Valid @RequestBody Ventas ventas, BindingResult br){
        if (br.hasErrors()){
            return ResponseEntity.badRequest().body(br.getAllErrors().get(0).getDefaultMessage());
        }
        try {
            Ventas actualizado = ventasService.updateVentas(id, ventas);
            return ResponseEntity.ok(actualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
