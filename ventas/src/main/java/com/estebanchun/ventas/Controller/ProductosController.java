package com.estebanchun.ventas.Controller;

import com.estebanchun.ventas.Entity.Productos;
import com.estebanchun.ventas.Service.ProductosService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductosController {
    private final ProductosService productosService;

    public ProductosController(ProductosService productosService) {
        this.productosService = productosService;
    }

    @GetMapping
    public List<Productos> getAllProductos(){ return productosService.getAllProductos(); }

    @PostMapping
    public ResponseEntity<Object> createProductos(@Valid @RequestBody Productos productos, BindingResult br){
        if (br.hasErrors()){
            return ResponseEntity.badRequest().body(br.getAllErrors().get(0).getDefaultMessage());
        }

        try {
            Productos createProductos = productosService.saveProducto(productos);
            return new ResponseEntity<>(createProductos, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getProductosById(@PathVariable Integer id){
        try {
            Productos buscarId = productosService.getProductosById(id);
            return ResponseEntity.status(404).body("No existe este Producto");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Error al buscar el Producto");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProducto(@PathVariable Integer id){
        try {
            if(productosService.getProductosById(id) == null) {
                return ResponseEntity.status(404).body("No exsite este Producto");
            }
            productosService.deleteProducto(id);
            return ResponseEntity.status(202).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al eliminar el Producto");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateProducto(@PathVariable Integer id, @Valid @RequestBody Productos productos, BindingResult br){
        if (br.hasErrors()){
            return ResponseEntity.badRequest().body(br.getAllErrors().get(0).getDefaultMessage());
        }
        try {
            Productos actualizado = productosService.updateProducto(id, productos);
            return ResponseEntity.ok(actualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
