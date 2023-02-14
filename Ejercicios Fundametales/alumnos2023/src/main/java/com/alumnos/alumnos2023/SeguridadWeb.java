
package com.alumnos.alumnos2023;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


//Con esto creamos la base de nuestra clase de seguridad


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SeguridadWeb extends WebSecurityConfigurerAdapter {    
   
    @Override
    protected void configure (HttpSecurity http) throws Exception{
      //Ahora creamos un objeto que va a autorizar determinados parametros 
      //para que 100pre que ingresemos a determinadas parte del sistema permita
      //todos los archivos cuyas ruta tengan los siguientes valores discriminados
      //De igual manera no ahce falta ser un usuario registrado para poder ver estos formatos
        http.authorizeRequests().antMatchers("/css/*","/js/*","/img/*","/**").permitAll();
        
    }
}
