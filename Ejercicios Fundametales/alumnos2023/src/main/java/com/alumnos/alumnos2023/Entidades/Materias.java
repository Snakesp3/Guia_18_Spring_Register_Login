
package com.alumnos.alumnos2023.Entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Materias {

    @Id
    //Auto generamos id
    @GeneratedValue(generator = "uuid")
    //Nos aseguramos que las id no se repitan
    @GenericGenerator(name = "uuid",strategy = "uuid2")
    private String id;
    private String asignatura;

    public Materias() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

   

}
