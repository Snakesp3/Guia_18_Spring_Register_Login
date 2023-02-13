/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alumnos.alumnos2023.Entidades;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.ManyToAny;

@Entity
public class Alumnos {

    @Id
    private Integer idAlumnos;
    private String nombre;
    private Integer dni;

    @Temporal(TemporalType.DATE)
    private Date alta;

   @ManyToOne
    private Escuelas escuelas;
   @ManyToOne
    private Materias materias;

    public Alumnos() {
    }

    public Integer getIdAlumnos() {
        return idAlumnos;
    }

    public void setIdAlumnos(Integer idAlumnos) {
        this.idAlumnos = idAlumnos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public Date getAlta() {
        return alta;
    }

    public void setAlta(Date alta) {
        this.alta = alta;
    }

    public Escuelas getEscuelas() {
        return escuelas;
    }

    public void setEscuelas(Escuelas escuelas) {
        this.escuelas = escuelas;
    }

    public Materias getMaterias() {
        return materias;
    }

    public void setMaterias(Materias materias) {
        this.materias = materias;
    }
   
   

   

    

}
