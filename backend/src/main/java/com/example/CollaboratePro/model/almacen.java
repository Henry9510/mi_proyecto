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
@OneToOne: Relación uno a uno, donde cada entidad A tiene una instancia única de entidad B y viceversa.
@OneToMany: Relación uno a muchos, donde una entidad A puede estar relacionada con muchas instancias de entidad B.
@ManyToOne: Relación muchos a uno, donde muchas instancias de entidad A están relacionadas con una sola instancia de entidad B.
@ManyToMany: Relación muchos a muchos, donde muchas instancias de entidad A están relacionadas con muchas instancias de entidad B.
 */

 
@Entity
public class almacen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    
    
    int producto;
    int cantidad_almacen;

    
    public almacen() {
        super();
    }

    public almacen(int id, int producto, int cantidad_almacen) {
        this.id = id;
        this.producto = producto;
        this.cantidad_almacen = cantidad_almacen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProducto() {
        return producto;
    }

    public void setProducto(int producto) {
        this.producto = producto;
    }

    public int getCantidad_almacen() {
        return cantidad_almacen;
    }

    public void setCantidad_almacen(int cantidad_almacen) {
        this.cantidad_almacen = cantidad_almacen;
    }


    
    
}
