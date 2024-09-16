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

import com.example.CollaboratePro.Repository.EmpleadoRepository;
import com.example.CollaboratePro.model.Empleado;





@RestController
public class EmpleadoController {

    private final EmpleadoRepository repositorio;

    public EmpleadoController(EmpleadoRepository repositorio) {
        this.repositorio = repositorio;
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping("/api/empleado")
    public List<Empleado> obtenerEmpleados() {
        return repositorio.findAll();
    }



    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping("/api/empleado/{id}")
    public ResponseEntity<Empleado> obtenerEmpleado(@PathVariable Long id) {
        Optional<Empleado> opt = repositorio.findById(id);
        return opt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping("/api/empleado")
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    public ResponseEntity<Empleado> guardarEmpleado(@RequestBody Empleado Empleado) {
        if (Empleado.getId() > 0) {
            return ResponseEntity.badRequest().build();
        }
        Empleado savedEmpleado = repositorio.save(Empleado);
        return ResponseEntity.ok(savedEmpleado);
    }

    @PutMapping("/api/empleado/{id}")
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    public ResponseEntity<Empleado> actualizarEmpleado(@PathVariable Long id, @RequestBody Empleado Empleado) {
        if (!repositorio.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        Empleado existingEmpleado = repositorio.findById(id).orElse(null);
        
        if (existingEmpleado == null) {
            return ResponseEntity.notFound().build();
        }
        
        // Actualizar el empleado existente con los nuevos valores
        existingEmpleado.setCedula(Empleado.getCedula());
        existingEmpleado.setNombre(Empleado.getNombre());
        existingEmpleado.setSegundoNombre(Empleado.getSegundoNombre());
        existingEmpleado.setApellido(Empleado.getApellido());
        existingEmpleado.setSegundoApellido(Empleado.getSegundoApellido());
        existingEmpleado.setEdad(Empleado.getEdad());
        existingEmpleado.setCargo(Empleado.getCargo());
        existingEmpleado.setFechaIngreso(Empleado.getFechaIngreso());

        Empleado updatedEmpleado = repositorio.save(existingEmpleado);
        
        return ResponseEntity.ok(updatedEmpleado);
    }

    @DeleteMapping("/api/empleado/{id}")
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    public ResponseEntity<Void> borrarEmpleado(@PathVariable Long id) {
        if (id == null || !repositorio.existsById(id)) {
            return ResponseEntity.badRequest().build();
        }

        repositorio.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
