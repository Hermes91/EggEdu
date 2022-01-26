package ejercicio1.ex.Libreria.controladores;

import ejercicio1.ex.Libreria.Errores.ErrorServicio;
import ejercicio1.ex.Libreria.entidades.Usuario;
import ejercicio1.ex.Libreria.servicios.UsuarioServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//* @author HermesCh

@Controller
@RequestMapping("/")
public class WebControlador {

    @Autowired
    private UsuarioServicio userServ;

///////////////////////////////////////////    
    
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USUARIO')") 
    @GetMapping("/")
    public String index(ModelMap modelo) {
        List<Usuario> usuariosActivos = userServ.todosLosUsuarios();
        modelo.addAttribute("usuario", usuariosActivos);
        return "index";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USUARIO')")
    @GetMapping("/inicio")
    public String inicio(ModelMap modelo) {
        List<Usuario> usuarios = userServ.todosLosUsuarios();
        modelo.addAttribute("usuarios", usuarios);

        return "inicio.html";
    }

    @GetMapping("/login")
    public String login(ModelMap model) {
        return "login.html";
    }

    @GetMapping("/log-on")
    public String logon(@RequestParam(required = false) String error, @RequestParam(required = false) String logout, ModelMap model) {

        if (error != null) {
            model.put("error", "Usuario o clave incorrectos");
        }
        if (logout != null) {
            model.put("logout", "Ha salido correctamente.");
        }
        return "log-on.html";
    }

///////////////////////////////////////////

    @GetMapping("/registro")
    public String registro(ModelMap modelo) {
        return "reg-form.html";
    }
    
    @PostMapping("/registrar")
    public String registrar(ModelMap modelo, @RequestParam String nombre, @RequestParam String apellido, @RequestParam String mail, @RequestParam String clave, @RequestParam String clave2) {

        try {
            userServ.registrar( nombre, apellido, mail, clave, clave2);

        } catch (ErrorServicio ex) {
            modelo.put("nombre", nombre);
            modelo.put("apellido", apellido);
            modelo.put("mail", mail);
            modelo.put("clave", clave);
            modelo.put("clave2", clave2);

            modelo.put("error", ex.getMessage());
            return "reg-form.html";
        }
        modelo.put("titulo", "¡Bienvenido!");
        modelo.put("descripcion", "Tu usuario fue registrado de manera satisfactoria");
        return "exito.html";
    }
}
