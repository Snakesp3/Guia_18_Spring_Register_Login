
package com.alumnos.alumnos2023.Repositorios;

import com.alumnos.alumnos2023.Entidades.Usuario;
import org.springframework.data.annotation.QueryAnnotation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario,String> {
 
    //Creamos un metodo de un usuario segun su email
    @Query("SELECT u FROM Usuario u WHERE u.email = :email")
    public Usuario buscarPorEmail (@Param("email")String email);
    
}
