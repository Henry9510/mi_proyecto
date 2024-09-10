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

import com.example.CollaboratePro.Repository.TransferenciaProjectRepository;
import com.example.CollaboratePro.model.transferencia_proyecto;



@RestController
public class TranferenciaProjectController {




    public final TransferenciaProjectRepository repositorio; 


    public TranferenciaProjectController(TransferenciaProjectRepository repository)
    {
        this.repositorio = repository;

    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping("/api/transferencia_proyecto")
    public List<transferencia_proyecto> obtenerTransferenciaProyectos() {
        return repositorio.findAll();
    }

    
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping("/transferencia_proyecto/{id}")
    public ResponseEntity<transferencia_proyecto> obtenerTransferenciaProyecto(@PathVariable Long id) {
        Optional<transferencia_proyecto> opt = repositorio.findById(id);
        
        return opt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping("/transferencia_proyecto")
    public ResponseEntity<transferencia_proyecto> guardarTransferenciaProyecto(@RequestBody transferencia_proyecto transferenciaProyecto) {
        // Verifica si el proyecto tiene un ID ya establecido
        if (transferenciaProyecto.getIdTranferenciaProyecto() != 0) {
            // Retorna un error 400 Bad Request si el ID ya está presente
            return ResponseEntity.badRequest().build();
        }

        // Guarda el nuevo proyecto en la base de datos
        transferencia_proyecto savedTransferenciaProyecto = repositorio.save(transferenciaProyecto);

        // Retorna el proyecto guardado con estado HTTP 201 Created
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTransferenciaProyecto);
    }

    @PutMapping("/transferencia_proyecto/{id}")
    public ResponseEntity<transferencia_proyecto> actualizarTransferenciaProyecto(@PathVariable Long id, @RequestBody transferencia_proyecto transferenciaProyecto) {
        // Verifica si el proyecto con el ID dado existe
        if (!repositorio.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        // Recupera el proyecto existente
        transferencia_proyecto existingTransferenciaProyecto = repositorio.findById(id).orElse(null);

        if (existingTransferenciaProyecto == null) {
            return ResponseEntity.notFound().build();
        }

       

        // Guarda el proyecto actualizado
        transferencia_proyecto updatedTransferenciaProyecto = repositorio.save(existingTransferenciaProyecto);

        // Retorna el proyecto actualizado con un estado HTTP 200 OK
        return ResponseEntity.ok(updatedTransferenciaProyecto);
    }

    @DeleteMapping("/transferencia_proyecto/{id}")
    public ResponseEntity<Void> borrarTransferenciaProyecto(@PathVariable Long id) {
        if (id == null || !repositorio.existsById(id)) {
            return ResponseEntity.badRequest().build();
        }

        repositorio.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
