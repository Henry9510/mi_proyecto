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
    public ResponseEntity<Producto> obtenerProducto(@PathVariable int id) {
        Optional<Producto> opt = repositorio.findById(id);

        return opt.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
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

    @PutMapping("/api/producto")
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    public ResponseEntity<Producto> actualizarProducto(@RequestBody Producto Producto) {
        if (Producto.getId() == 0 || repositorio.existsById(Producto.getId())) {
            return ResponseEntity.badRequest().build();
        }

        repositorio.save(Producto);
        return ResponseEntity.ok(Producto);
    }

    @DeleteMapping("/api/producto")
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    public ResponseEntity<Producto> borrarProducto(@PathVariable int id) {
        if (id == 0 || repositorio.existsById(id)) {
            return ResponseEntity.badRequest().build();
        }

        repositorio.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
