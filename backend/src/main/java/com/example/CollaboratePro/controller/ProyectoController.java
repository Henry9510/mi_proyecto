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

import com.example.CollaboratePro.Repository.ProyectoRepository;
import com.example.CollaboratePro.model.Proyecto;

@RestController
public class ProyectoController {

    private final ProyectoRepository repositorio;

    public ProyectoController(ProyectoRepository repository) {
        this.repositorio = repository;
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping("/api/proyecto")
    public List<Proyecto> obtenerProyecto() {
        return repositorio.findAll();
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping("/api/proyecto/{id}")
    public ResponseEntity<Proyecto> obtenerProyecto(@PathVariable Long id) {
        Optional<Proyecto> opt = repositorio.findById(id);

        return opt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping("/api/proyecto")
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    public ResponseEntity<Proyecto> guardarProyecto(@RequestBody Proyecto proyecto) {
        // Verifica si el proyecto tiene un ID ya establecido
        if (proyecto.getId() != 0) {
            // Retorna un error 400 Bad Request si el ID ya está presente
            return ResponseEntity.badRequest().build();
        }
    
        // Guarda el nuevo proyecto en la base de datos
        Proyecto savedProyecto = repositorio.save(proyecto);
    
        // Retorna el proyecto guardado con estado HTTP 201 Created
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProyecto);
    }



    @PutMapping("/api/proyecto/{id}")
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    public ResponseEntity<Proyecto> actualizarProyecto(@PathVariable Long id, @RequestBody Proyecto Proyecto) {
        // Check if the product with the given ID exists
        if (!repositorio.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        // Retrieve the existing product
        Proyecto existingProyecto = repositorio.findById(id).orElse(null);
        
        if (existingProyecto == null) {
            return ResponseEntity.notFound().build();
        }

           // Update the existing product with new values
        existingProyecto.setDescripcionProyecto(Proyecto.getDescripcionProyecto());
        existingProyecto.setNumeroProyecto(Proyecto.getNumeroProyecto());
        existingProyecto.setHorasEstimadas(Proyecto.getHorasEstimadas());
        

        // Save the updated product
        Proyecto updatedProyecto = repositorio.save(existingProyecto);
        
        // Return the updated product with an HTTP 200 OK status
        return ResponseEntity.ok(updatedProyecto);
    }

    

    
    @DeleteMapping("/api/proyecto/{id}")
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    public ResponseEntity<Proyecto> borrarProducto(@PathVariable Long id) {
        if (id == null || !repositorio.existsById(id)) {
            return ResponseEntity.badRequest().build();
        }

        repositorio.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
