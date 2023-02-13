package com.alumnos.alumnos2023.Servicios;

import com.alumnos.alumnos2023.Entidades.Escuelas;
import com.alumnos.alumnos2023.Entidades.Materias;
import com.alumnos.alumnos2023.Repositorios.MateriasRepositorio;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MateriasServicio {

    @Autowired
    MateriasRepositorio materiasrepositorio;

    
    //Si se aplica una accion y no se ejecuta lo esperado volvera a cargar la pagina
    //Todo los metodos que modifiquen de forma permanente la base de datos deberan ser
    //tratados con una "transactional"
    @Transactional
    public void crearMaterias(String asignatura) {
        //Creamos un objeto
        Materias materias = new Materias();

        //Setteamos
        materias.setAsignatura(asignatura);
        //Persistimos
        materiasrepositorio.save(materias);
    }

    //Creamos una Lista para guardar todas las materias que encontremos
    public List<Materias> listarMaterias() {

        List<Materias> materias = new ArrayList();

        materias = materiasrepositorio.findAll();

        return materias;

    }
}
