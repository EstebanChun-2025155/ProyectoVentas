package com.estebanchun.ventas.Controller;

import com.estebanchun.ventas.Entity.DetalleVentas;
import com.estebanchun.ventas.Service.DetalleVentasService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/DetalleVenta")
public class DetalleVentasController {
    private final DetalleVentasService detalleVentasService;

    public DetalleVentasController(DetalleVentasService detalleVentasService) {
        this.detalleVentasService = detalleVentasService;
    }

    @GetMapping
    public List<DetalleVentas> getAllDetalleVentas(){ return detalleVentasService.getAllDetalleVentas(); }

    @PostMapping
    public ResponseEntity<Object> createDetalleVentas(@Valid @RequestBody DetalleVentas detalleVentas, BindingResult br){
        if (br.hasErrors()){
            return ResponseEntity.badRequest().body(br.getAllErrors().get(0).getDefaultMessage());
        }

        try {
            DetalleVentas createDetalleVentas = detalleVentasService.saveDetalleVentas(detalleVentas);
            return new ResponseEntity<>(createDetalleVentas, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getDetalleVentasById(@PathVariable Integer id){
        try {
            DetalleVentas buscarId = detalleVentasService.getDetalleVentasById(id);
            return ResponseEntity.status(404).body("No existe este Registro de Venta");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Error al buscar el Registro de Venta");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteDetalleVentas(@PathVariable Integer id){
        try {
            if(detalleVentasService.getDetalleVentasById(id) == null) {
                return ResponseEntity.status(404).body("No exsite este Resistro de Venta");
            }
            detalleVentasService.deleteDetalleVentas(id);
            return ResponseEntity.status(202).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al eliminar el Registro de Venta");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateDetalleVentas(@PathVariable Integer id, @Valid @RequestBody DetalleVentas detalleVentas, BindingResult br){
        if (br.hasErrors()){
            return ResponseEntity.badRequest().body(br.getAllErrors().get(0).getDefaultMessage());
        }
        try {
            DetalleVentas actualizado = detalleVentasService.updateDetalleVentas(id, detalleVentas);
            return ResponseEntity.ok(actualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
