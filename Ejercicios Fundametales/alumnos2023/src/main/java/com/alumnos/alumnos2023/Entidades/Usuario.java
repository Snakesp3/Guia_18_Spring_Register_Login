package com.alumnos.alumnos2023.Entidades;

import com.alumnos.alumnos2023.Enumeraciones.Rol;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Usuario {

    @Id
    //Auto generamos id
    @GeneratedValue(generator = "uuid")
    //Nos aseguramos que las id no se repitan
    @GenericGenerator(name = "uuid", strategy = "uuid2")

    private String id;
    private String nombre;
    private String gmail;
    private String password;
    //Avisamos por medio de una anotacion que es de tipo "Enum" y le vamos a decir
    //que el tipo de dato que maneja es en este caso un "String"
    @Enumerated(EnumType.STRING)
    private Rol rol;

    public Usuario() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
    
    
}
