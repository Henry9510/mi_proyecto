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
@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    
    int codigo;
    String Nombre;
    String PartNumber;
    String Unidad;
    String Procedencia;
    String Material;
    int Precio;

    
    public Producto() {
        super();
    }

    public Producto( String Nombre, String PartNumber, String Unidad, String Procedencia, String Material, int Precio,int codigo) {
        
        this.Nombre = Nombre;
        this.PartNumber = PartNumber;
        this.Unidad = Unidad;
        this.Procedencia = Procedencia;
        this.Material = Material;
        this.Precio = Precio;
        this.codigo = codigo;
    }
    

  


    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return this.Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getPartNumber() {
        return this.PartNumber;
    }

    public void setPartNumber(String PartNumber) {
        this.PartNumber = PartNumber;
    }

    public String getUnidad() {
        return this.Unidad;
    }

    public void setUnidad(String Unidad) {
        this.Unidad = Unidad;
    }

    public String getProcedencia() {
        return this.Procedencia;
    }

    public void setProcedencia(String Procedencia) {
        this.Procedencia = Procedencia;
    }

    public String getMaterial() {
        return this.Material;
    }

    public void setMaterial(String Material) {
        this.Material = Material;
    }

    public int getPrecio() {
        return this.Precio;
    }

    public void setPrecio(int Precio) {
        this.Precio = Precio;
    }
   


    
    
}
