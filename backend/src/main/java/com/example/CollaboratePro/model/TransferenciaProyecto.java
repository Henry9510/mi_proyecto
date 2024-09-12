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
public class TransferenciaProyecto {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idTranferenciaProyecto;

    String fecha;
    int proyecto;
    String listaPedido;
    int numReq;


    public TransferenciaProyecto() {
    }


    public TransferenciaProyecto(String fecha, int proyecto, String listaPedido, int numReq) {

        this.fecha = fecha;
        this.proyecto = proyecto;
        this.listaPedido = listaPedido;
        this.numReq = numReq;
    }



    public long getIdTranferenciaProyecto() {
        return this.idTranferenciaProyecto;
    }

    public void setIdTranferenciaProyecto(long idTranferenciaProyecto) {
        this.idTranferenciaProyecto = idTranferenciaProyecto;
    }

    public String getfecha() {
        return this.fecha;
    }

    public void setfecha(String fecha) {
        this.fecha = fecha;
    }

    public int getProyecto() {
        return this.proyecto;
    }

    public void setProyecto(int proyecto) {
        this.proyecto = proyecto;
    }

    public String getListaPedido() {
        return this.listaPedido;
    }

    public void setListaPedido(String listaPedido) {
        this.listaPedido = listaPedido;
    }

    public int getNumReq() {
        return this.numReq;
    }

    public void setNumReq(int numReq) {
        this.numReq = numReq;
    }

}