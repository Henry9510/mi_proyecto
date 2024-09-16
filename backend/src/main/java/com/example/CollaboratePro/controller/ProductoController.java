package com.example.CollaboratePro.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.CollaboratePro.Repository.ProductoRepository;
import com.example.CollaboratePro.model.Producto;



@RestController
public class ProductoController {

    private final ProductoRepository repositorio;

    public ProductoController(ProductoRepository repository) {
        this.repositorio = repository;
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping("/api/producto")
    public List<Producto> obtenerProducto() {
        return repositorio.findAll();
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping("/api/producto/{id}")
    public ResponseEntity<Producto> obtenerProducto(@PathVariable Long id) {
        Optional<Producto> opt = repositorio.findById(id);

        return opt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping("/api/producto")
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    public ResponseEntity<Producto> guardarProducto(@RequestBody Producto Producto) {
        if (Producto.getId() != 0) {
            return ResponseEntity.badRequest().build();
        }
        repositorio.save(Producto);
        return ResponseEntity.ok(Producto);
    }

    @PutMapping("/api/producto/{id}")
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable Long id, @RequestBody Producto Producto) {
        // Check if the product with the given ID exists
        if (!repositorio.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        // Retrieve the existing product
        Producto existingProducto = repositorio.findById(id).orElse(null);
        
        if (existingProducto == null) {
            return ResponseEntity.notFound().build();
        }
        
        // Update the existing product with new values
        existingProducto.setCodigo(Producto.getCodigo());
        existingProducto.setNombre(Producto.getNombre());
        existingProducto.setUnidad(Producto.getUnidad());
        existingProducto.setMaterial(Producto.getMaterial());
        existingProducto.setPrecio(Producto.getPrecio());
        existingProducto.setProcedencia(Producto.getProcedencia());
        existingProducto.setPartNumber(Producto.getPartNumber());

        // Save the updated product
        Producto updatedProducto = repositorio.save(existingProducto);
        
        // Return the updated product with an HTTP 200 OK status
        return ResponseEntity.ok(updatedProducto);
    }

    

    
    @DeleteMapping("/api/producto/{id}")
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    public ResponseEntity<Producto> borrarProducto(@PathVariable Long id) {
        if (id == null || !repositorio.existsById(id)) {
            return ResponseEntity.badRequest().build();
        }

        repositorio.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
