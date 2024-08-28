package com.example.CollaboratePro.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.CollaboratePro.Repository.ProductoRepository;
import com.example.CollaboratePro.model.Producto;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")  // Configuración CORS global para todos los métodos
public class ProductoController {
    
    private final ProductoRepository repositorio;
    
    public ProductoController(ProductoRepository repository){
        this.repositorio = repository;
    }
   
    @PostMapping("/api/crearProducto")
    public ResponseEntity<Void> crearProducto(){
        Producto producto1 = new Producto("brida","123","unico","nal","acero", 0);
        Producto producto2 = new Producto("empaque","124","paquete","nal","buna",100);
        Producto producto3 = new Producto("diesel","1243","galon","nal","null",520);
     
        repositorio.save(producto1);
        repositorio.save(producto2);
        repositorio.save(producto3);
        
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/api/producto")
    public List<Producto> obtenerProducto(){
        return repositorio.findAll();
    }

    @GetMapping("/api/producto/{id}")
    public ResponseEntity<Producto> obtenerProducto(@PathVariable int id){
        Optional<Producto> opt = repositorio.findById(id);

        return opt.map(ResponseEntity::ok)
                  .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping("/api/producto")
    public ResponseEntity<Producto> guardarProducto(@RequestBody Producto producto) {
        if (producto.getId() != 0) {
            return ResponseEntity.badRequest().build();
        }

        Producto savedProducto = repositorio.save(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProducto);
    }
}
