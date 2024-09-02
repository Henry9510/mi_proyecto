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
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    int NumeroProyecto;
    String DescripcionProyecto;
    int HorasEstimadas;

    public Proyecto() {
        super();
    }


    public Proyecto(int NumeroProyecto, String Descripcion, int HorasEstimadas) {
        
        this.NumeroProyecto = NumeroProyecto;
        this.DescripcionProyecto = Descripcion;
        this.HorasEstimadas = HorasEstimadas;
    }


    
    public long getId() {
        return this.id;
    }

   
  
 

    public int getNumeroProyecto() {
        return this.NumeroProyecto;
    }

    public void setNumeroProyecto(int NumeroProyecto) {
        this.NumeroProyecto = NumeroProyecto;
    }

    public String getDescripcionProyecto() {
        return this.DescripcionProyecto;
    }

    public void setDescripcionProyecto(String DescripcionProyecto) {
        this.DescripcionProyecto = DescripcionProyecto;
    }

    public int getHorasEstimadas() {
        return this.HorasEstimadas;
    }

    public void setHorasEstimadas(int HorasEstimadas) {
        this.HorasEstimadas = HorasEstimadas;
    }


    
}
