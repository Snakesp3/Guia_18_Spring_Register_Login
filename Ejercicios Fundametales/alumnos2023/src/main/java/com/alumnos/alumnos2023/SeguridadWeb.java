
package com.alumnos.alumnos2023;

import com.sun.xml.internal.ws.developer.HttpConfigFeature;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//Con esto creamos la base de nuestra clase de seguridad
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SeguridadWeb extends WebSecurityConfigurerAdapter{
    
    protected void configure(HttpConfigFeature http) throws Exception {
        
        //Seguir viendo video configuracion inicial en el min 7.05
    }
    
}
