
package com.alumnos.alumnos2023.Repositorios;

import com.alumnos.alumnos2023.Entidades.Alumnos;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnosRepositorio extends JpaRepository<Alumnos,Integer>{
    
    @Query("SELECT a FROM Alumnos a WHERE a.nombre = :nombre")
    //La anotacion Param hace referencia a los atributos de Alumnos
    public Alumnos buscarporNombre(@Param("nombre") String nombre);
    
    @Query("SELECT a FROM Alumnos a WHERE a.dni = :dni")
    public List<Alumnos>buscarPorDni(@Param ("dni")String dni);
}
