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

import com.example.CollaboratePro.Repository.RegistroHorasRepository;
import com.example.CollaboratePro.model.registro_horas;


@RestController
public class RegistroHorasController {

    public final RegistroHorasRepository repositorio; 
    public RegistroHorasController(RegistroHorasRepository repository)
    {
        this.repositorio = repository;

    }
     @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping("/api/registro_horas")
    public List<registro_horas> obtenerRegistroHoras() {
        return repositorio.findAll();
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping("/api/registro_horas/{id}")
    public ResponseEntity<registro_horas> obtenerRegistroHorasxproyecto(@PathVariable Long id) {
        Optional<registro_horas> opt = repositorio.findById(id);

        return opt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping("/api/registro_horas")
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    public ResponseEntity<registro_horas> guardarRegistroHoras(@RequestBody registro_horas registro_horas) {
        // Verifica si el proyecto tiene un ID ya establecido
        if (registro_horas.getidRegistroHoras() != 0) {
            // Retorna un error 400 Bad Request si el ID ya está presente
            return ResponseEntity.badRequest().build();
        }
    
        // Guarda el nuevo proyecto en la base de datos
        registro_horas savedRegistrohoras = repositorio.save(registro_horas);
    
        // Retorna el proyecto guardado con estado HTTP 201 Created
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRegistrohoras);
    }



    @PutMapping("/api/registro_horas/{id}")
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    public ResponseEntity<registro_horas> actualizarRegistroHoras(@PathVariable Long id, @RequestBody registro_horas registro_horas) {
        // Check if the product with the given ID exists
        if (!repositorio.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        // Retrieve the existing product
        registro_horas existingProyecto = repositorio.findById(id).orElse(null);
        
        if (existingProyecto == null) {
            return ResponseEntity.notFound().build();
        }

           // Update the existing product with new values
        existingProyecto.setEmpleador(registro_horas.getEmpleador());
        existingProyecto.setFecha(registro_horas.getFecha());
        existingProyecto.setHorasTrabajadasnar(registro_horas.getHorasTrabajadasnar());
        existingProyecto.setProyecto(registro_horas.getProyecto());
        existingProyecto.setUsuario(registro_horas.getUsuario());
        

        // Save the updated product
        registro_horas updatedProyecto = repositorio.save(existingProyecto);
        
        // Return the updated product with an HTTP 200 OK status
        return ResponseEntity.ok(updatedProyecto);
    }

    

    
    @DeleteMapping("/api/registro_horas/{id}")
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    public ResponseEntity<registro_horas> borrarRegistrHoras(@PathVariable Long id) {
        if (id == null || !repositorio.existsById(id)) {
            return ResponseEntity.badRequest().build();
        }

        repositorio.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

        
    

