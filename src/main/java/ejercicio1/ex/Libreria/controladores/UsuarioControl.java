package ejercicio1.ex.Libreria.controladores;

import ejercicio1.ex.Libreria.Errores.ErrorServicio;
import ejercicio1.ex.Libreria.entidades.Usuario;
import ejercicio1.ex.Libreria.servicios.UsuarioServicio;
import javax.servlet.http.HttpSession;
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
@RequestMapping("/usuario")
public class UsuarioControl {

    @Autowired
    private UsuarioServicio userServ;
  
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USUARIO')")
    @GetMapping("/editar-perfil")
    public String editarPerfil(HttpSession session, @RequestParam String id, ModelMap model) {

        Usuario login = (Usuario) session.getAttribute("usuariosession");
        if (login == null || !login.getId().equals(id)) {
            return "redirect:/inicio";
        }
        try {
            Usuario user = userServ.buscarPorId(id);
            model.addAttribute("perfil", user);
        } catch (ErrorServicio e) {
            model.addAttribute("error", e.getMessage());
        }
        return "perfil.html";
    }
    
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USUARIO')")
    @PostMapping("/actualizar-perfil")
    public String registrar(ModelMap modelo, HttpSession session, @RequestParam String id, @RequestParam String nombre, @RequestParam String apellido, @RequestParam String mail, @RequestParam String clave, @RequestParam String clave2) {

        Usuario usuario = null;
        try {
            
            Usuario login = (Usuario) session.getAttribute("usuariosession");
            if (login == null || !login.getId().equals(id)) {
                return "redirect:/inicio";
            }

            usuario = userServ.buscarPorId(id);
            userServ.modificar( id, nombre, apellido, mail, clave, clave2);
            session.setAttribute("usuariosession", usuario);
            
            return "redirect:/inicio";
            
        } catch (ErrorServicio e) {
            modelo.put("error", "Datos incorrectos");
            modelo.put("perfil", usuario);

            return "perfil.html";
        }
    }
}
