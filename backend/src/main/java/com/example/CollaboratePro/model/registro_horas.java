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
public class registro_horas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idRegistroHoras;

    String Fecha;
    int HorasTrabajadasnar;
    int Proyecto;
    int Usuario;
    int Empleador;


    public registro_horas() {
        super();
    }


    public registro_horas( String Fecha, int HorasTrabajadasnar, int Proyecto, int Usuario, int Empleador) {
     
        this.Fecha = Fecha;
        this.HorasTrabajadasnar = HorasTrabajadasnar;
        this.Proyecto = Proyecto;
        this.Usuario = Usuario;
        this.Empleador = Empleador;
    }
    


    public Long getidRegistroHoras() {
        return this.idRegistroHoras;
    }



    public String getFecha() {
        return this.Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public int getHorasTrabajadasnar() {
        return this.HorasTrabajadasnar;
    }

    public void setHorasTrabajadasnar(int HorasTrabajadasnar) {
        this.HorasTrabajadasnar = HorasTrabajadasnar;
    }

    public int getProyecto() {
        return this.Proyecto;
    }

    public void setProyecto(int Proyecto) {
        this.Proyecto = Proyecto;
    }

    public int getUsuario() {
        return this.Usuario;
    }

    public void setUsuario(int Usuario) {
        this.Usuario = Usuario;
    }

    public int getEmpleador() {
        return this.Empleador;
    }

    public void setEmpleador(int Empleador) {
        this.Empleador = Empleador;
    }


}
