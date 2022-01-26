
package ejercicio1.ex.Libreria.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//* @author HermesCh

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class Security extends WebSecurityConfigurerAdapter{
    
    @Override
    protected void configure(HttpSecurity http) throws Exception{
    http
            .authorizeRequests()
            .antMatchers("/admin/").hasRole("ADMIN")
            .antMatchers("/css/*","/js/*","/img/*","/**").permitAll()
            .and()
            .formLogin()
            .loginPage("/login")
            .loginProcessingUrl("/logincheck")
            .usernameParameter("username")
            .passwordParameter("password")
            .defaultSuccessUrl("/inicio")
            .permitAll().and().logout()
            .logoutUrl("/logout")
            .logoutSuccessUrl("/log-on?logout").permitAll()
            .and().csrf().disable()
            ;
    } 
}
