
package com.alumnos.alumnos2023.Excepciones;

//Al crear una clase Excepciones lo que hacemos es personalizar un msj de error propio y diferenciandolo de los problemas
//propios del sistema
public class MiExcepciones extends Exception {
    //Creamos un constructor y que simplemente reciba un msj 
    public MiExcepciones(String msj){
        //Para que luego llame al padre para que reciba ese msj
        super(msj);
        
        
    }
}
