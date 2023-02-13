
package com.alumnos.alumnos2023.Repositorios;

import com.alumnos.alumnos2023.Entidades.Escuelas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EscuelasRepositorio extends JpaRepository<Escuelas,String>{
    
}
