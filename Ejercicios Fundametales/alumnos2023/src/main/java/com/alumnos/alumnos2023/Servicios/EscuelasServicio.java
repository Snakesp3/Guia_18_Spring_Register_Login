package com.alumnos.alumnos2023.Servicios;

import com.alumnos.alumnos2023.Entidades.Alumnos;
import com.alumnos.alumnos2023.Entidades.Escuelas;
import com.alumnos.alumnos2023.Repositorios.EscuelasRepositorio;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EscuelasServicio {

    @Autowired
    EscuelasRepositorio escuelasrepositorio;
    
    //Si se aplica una accion y no se ejecuta lo esperado volvera a cargar la pagina
    //Todo los metodos que modifiquen de forma permanente la base de datos deberan ser
    //tratados con una "transactional"
    @Transactional
    public void crearEscuelas(String nombre) {

        Escuelas escuelas = new Escuelas();

        escuelas.setNombre(nombre);

        escuelasrepositorio.save(escuelas);
    }

    //Creamos una Lista para guardar todas las escuelas que encontremos
    public List<Escuelas> listarEscuelas() {

        List<Escuelas> escuelas = new ArrayList();

        escuelas = escuelasrepositorio.findAll();

        return escuelas;

    }
    
    public void modificarEscuelas (String id,String nombre){
        
        Optional<Escuelas> respuesta = escuelasrepositorio.findById(id);
        
        if(respuesta.isPresent()){
            
            Escuelas escuelas = respuesta.get();
            
            escuelas.setNombre(nombre);
            
            escuelasrepositorio.save(escuelas);
        }
    }
    //fin video servicio 3
}
