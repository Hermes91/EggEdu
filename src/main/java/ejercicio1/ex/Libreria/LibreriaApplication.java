package ejercicio1.ex.Libreria;

import ejercicio1.ex.Libreria.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//* @author HermesCh

@SpringBootApplication
public class LibreriaApplication {

    @Autowired
    private UsuarioServicio userServ;

    public static void main(String[] args) {
        SpringApplication.run(LibreriaApplication.class, args);
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userServ)
                .passwordEncoder(new BCryptPasswordEncoder());

    }
}
