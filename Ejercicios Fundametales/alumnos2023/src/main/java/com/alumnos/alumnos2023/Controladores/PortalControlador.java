package com.alumnos.alumnos2023.Controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//Sera el encargado de dirigirnos a la pagina
@RequestMapping("/")
public class PortalControlador {

    //Mapeara el acceso a la url
    @GetMapping("/")
    public String index() {

        //Luego devolvemos la vista que queremos ver
        return "index.html";
    }

    @GetMapping("/registrar")
    public String registrar() {

        return "registro.html";
    }
    
    @GetMapping("/login")
    public String login() {

        return "login.html";
    }
    //Seguimos en el video Servicio Usuario
}
