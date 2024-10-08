/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.CollaboratePro.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 *
 * @author Henry
 */

 

/**
@OneToOne: Relación uno a uno, donde cada entidad A tiene una instancia única de entidad B y viceversa.
@OneToMany: Relación uno a muchos, donde una entidad A puede estar relacionada con muchas instancias de entidad B.
@ManyToOne: Relación muchos a uno, donde muchas instancias de entidad A están relacionadas con una sola instancia de entidad B.
@ManyToMany: Relación muchos a muchos, donde muchas instancias de entidad A están relacionadas con muchas instancias de entidad B.
 */


@Entity
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    int Cedula;
    String Nombre;
    String SegundoNombre;
    String Apellido;
    String SegundoApellido;
    int Edad;
    String Cargo;
    String FechaIngreso;

    public Empleado(int Cedula, String Nombre, String SegundoNombre, String Apellido, String SegundoApellido, int Edad,
            String Cargo, String FechaIngreso) {

        this.Cedula = Cedula;
        this.Nombre = Nombre;
        this.SegundoNombre = SegundoNombre;
        this.Apellido = Apellido;
        this.SegundoApellido = SegundoApellido;
        this.Edad = Edad;
        this.Cargo = Cargo;
        this.FechaIngreso = FechaIngreso;
    }

    public Empleado() {
        super();
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCedula() {
        return this.Cedula;
    }

    public void setCedula(int Cedula) {
        this.Cedula = Cedula;
    }

    public String getNombre() {
        return this.Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getSegundoNombre() {
        return this.SegundoNombre;
    }

    public void setSegundoNombre(String SegundoNombre) {
        this.SegundoNombre = SegundoNombre;
    }

    public String getApellido() {
        return this.Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getSegundoApellido() {
        return this.SegundoApellido;
    }

    public void setSegundoApellido(String SegundoApellido) {
        this.SegundoApellido = SegundoApellido;
    }

    public int getEdad() {
        return this.Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    public String getCargo() {
        return this.Cargo;
    }

    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }

    public String getFechaIngreso() {
        return this.FechaIngreso;
    }

    public void setFechaIngreso(String FechaIngreso) {
        this.FechaIngreso = FechaIngreso;
    }

}
