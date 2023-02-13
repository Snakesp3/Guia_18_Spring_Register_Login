package com.alumnos.alumnos2023.Servicios;

import com.alumnos.alumnos2023.Entidades.Alumnos;
import com.alumnos.alumnos2023.Entidades.Escuelas;
import com.alumnos.alumnos2023.Entidades.Materias;
import com.alumnos.alumnos2023.Excepciones.MiExcepciones;

import com.alumnos.alumnos2023.Repositorios.AlumnosRepositorio;
import com.alumnos.alumnos2023.Repositorios.EscuelasRepositorio;
import com.alumnos.alumnos2023.Repositorios.MateriasRepositorio;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlumnosServicio {

    //Indicamos al servidor de aplicaciones que esta variable va a ser inicializada por el
    @Autowired //(Esto se conoce como inyeccion de dependencia)
    private AlumnosRepositorio alumnosrepositorio;

    @Autowired
    private EscuelasRepositorio escuelasrepositorio;

    @Autowired
    private MateriasRepositorio materiasrepositorio;

    //Si se aplica una accion y no se ejecuta lo esperado volvera a cargar la pagina
    //Todo los metodos que modifiquen de forma permanente la base de datos deberan ser
    //tratados con una "transactional"
    @Transactional
    public void crearAlumnos(Integer idAlumnos, String nombre, Integer dni, String idEscuelas, String idMaterias) throws MiExcepciones {

        //Realizamos una validacion a efecto de decir que si no pasa tal cosa no se realizaran los cambios
        //Es decir si la Id se manda nula o queda vacia que se active "MiExcepciones"
        if (idAlumnos == null) {
            throw new MiExcepciones("El idAlumno no puede estar vacio o ser nulo");
        }
        //Tambien podemos validar otros valores
        if (nombre.isEmpty() || nombre == null) {
            throw new MiExcepciones("El Titulo no puede estar vacio o ser nulo");
        }
        //Creo una validacion para cada uno
        if (dni == null) {
            throw new MiExcepciones("El D.N.I no puede estar vacio o ser nulo");
        }
        //Tambien podemos validar otros valores
        if (idEscuelas.isEmpty() || idEscuelas == null) {
            throw new MiExcepciones("El idEscuelas no puede estar vacio o ser nulo");
        }
        
        if (idMaterias.isEmpty() || idMaterias == null) {
            throw new MiExcepciones("El idMaterias no puede estar vacio o ser nulo");
        }
        
        validar(idAlumnos,nombre,dni,idEscuelas,idMaterias);
        
        Escuelas escuelas = escuelasrepositorio.findById(idEscuelas).get();
        Materias materias = materiasrepositorio.findById(idMaterias).get();

        //Primero que nada creamos un objeto
        Alumnos alumnos = new Alumnos();

        //Luego de tener todos los atributos completo podemos guardar todo lo que cargue y lo persista luego a la base
        //de datos
        //Setteamos
        alumnos.setIdAlumnos(idAlumnos);
        alumnos.setNombre(nombre);
        alumnos.setDni(dni);
        alumnos.setAlta(new Date());

        alumnos.setEscuelas(escuelas);
        alumnos.setMaterias(materias);
        //Persistimos
        alumnosrepositorio.save(alumnos);

    }

    //Creamos una Lista para guardar todo los alumnos que encontremos
    public List<Alumnos> listarAlumnos() {

        List<Alumnos> alumnos = new ArrayList();

        alumnos = alumnosrepositorio.findAll();

        return alumnos;
    }

    //Metodo Modificar Alumnos
    //Explicacion breve en el video 3 Servicios en el min 7.49
    public void modificarAlumnos(Integer idAlumnos, String nombre, Integer dni, String idEscuelas, String idMaterias) throws MiExcepciones {
        
        //Ahora podemos reutilizar este metodo para validar en una sola linea de codigo
        validar(idAlumnos,nombre,dni,idEscuelas,idMaterias);
       
        //El Optional puede o no contener un valor no nulo, si el valor no es nulo
        //se podra retornar por medio de un get ese valor
        Optional<Alumnos> respuesta = alumnosrepositorio.findById(idAlumnos);

        Optional<Escuelas> respuestaEscuelas = escuelasrepositorio.findById(idEscuelas);

        Optional<Materias> respuestaMaterias = materiasrepositorio.findById(idMaterias);

        //Instanciamos Escuelas y Materias
        Escuelas escuelas = new Escuelas();
        Materias materias = new Materias();

        if (respuestaEscuelas.isPresent()) {

            escuelas = respuestaEscuelas.get();
        }

        if (respuestaMaterias.isPresent()) {

            materias = respuestaMaterias.get();
        }

        //Si la respuesta esta precente
        if (respuesta.isPresent()) {

            //Nos retornara por medio del get lo que buscamos
            Alumnos alumnos = respuesta.get();

            alumnos.setNombre(nombre);
            alumnos.setEscuelas(escuelas);
            alumnos.setMaterias(materias);
            alumnos.setDni(dni);
            //Ya teniendo todos los datos de los metodos creados como crear y modificar lo
            //persistimo en nuestra base de datos
            alumnosrepositorio.save(alumnos);

        }

    }
    // Para no repetir codigo y validar el "modificarAlumnos" solo crearemos otro metodo para
    //realizar esa misma funcion de forma mas simplificada
    
    private void validar (Integer idAlumnos, String nombre, Integer dni, String idEscuelas, String idMaterias) throws MiExcepciones{
        
        if (idAlumnos == null) {
            throw new MiExcepciones("El idAlumno no puede estar vacio o ser nulo");
        }
        //Tambien podemos validar otros valores
        if (nombre.isEmpty() || nombre == null) {
            throw new MiExcepciones("El Titulo no puede estar vacio o ser nulo");
        }
        //Creo una validacion para cada uno
        if (dni == null) {
            throw new MiExcepciones("El D.N.I no puede estar vacio o ser nulo");
        }
        //Tambien podemos validar otros valores
        if (idEscuelas.isEmpty() || idEscuelas == null) {
            throw new MiExcepciones("El idEscuelas no puede estar vacio o ser nulo");
        }
        
        if (idMaterias.isEmpty() || idMaterias == null) {
            throw new MiExcepciones("El idMaterias no puede estar vacio o ser nulo");
        }
        
    }
    

}
