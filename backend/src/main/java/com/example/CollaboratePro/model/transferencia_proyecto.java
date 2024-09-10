/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.CollaboratePro.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 *
 * @author Henry
 */
public class transferencia_proyecto {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idTranferenciaProyecto;

    String Fecha;
    int proyecto;
    int codigo;
    String descripcion;
    int numParte;
    int cantidad;
    int numReq;


    public transferencia_proyecto() {
    }



    public transferencia_proyecto(String Fecha, int proyecto, int codigo, String descripcion, int numParte, int cantidad, int numReq) {
     
        this.Fecha = Fecha;
        this.proyecto = proyecto;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.numParte = numParte;
        this.cantidad = cantidad;
        this.numReq = numReq;
    }



    public long getIdTranferenciaProyecto() {
        return this.idTranferenciaProyecto;
    }

    public void setIdTranferenciaProyecto(long idTranferenciaProyecto) {
        this.idTranferenciaProyecto = idTranferenciaProyecto;
    }

    public String getFecha() {
        return this.Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public int getProyecto() {
        return this.proyecto;
    }

    public void setProyecto(int proyecto) {
        this.proyecto = proyecto;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getNumParte() {
        return this.numParte;
    }

    public void setNumParte(int numParte) {
        this.numParte = numParte;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getNumReq() {
        return this.numReq;
    }

    public void setNumReq(int numReq) {
        this.numReq = numReq;
    }

}