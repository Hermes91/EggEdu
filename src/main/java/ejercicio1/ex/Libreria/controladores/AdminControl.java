package ejercicio1.ex.Libreria.controladores;

import ejercicio1.ex.Libreria.entidades.Usuario;
import ejercicio1.ex.Libreria.servicios.UsuarioServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

//* @author HermesCh

@Controller
@RequestMapping("/admin")
public class AdminControl {

    @Autowired
    UsuarioServicio userServ;

    @GetMapping("/dashboard")
    public String inicioAdmin(ModelMap modelo) {
        List<Usuario> usuarios = userServ.todosLosUsuarios();
        modelo.put("usuarios", usuarios);

        return "inicioAdmin";
    }

    @GetMapping("/habilitar/{id}")
    public String habilitar(ModelMap modelo, @PathVariable String id) {
        try {
            userServ.habilitar(id);
            return "redirect:/admin/dashboard";
        } catch (Exception e) {
            modelo.put("error", "No fue posible habilitar al usuario");
            return "inicioAdmin";
        }
    }

    @GetMapping("/deshabilitar/{id}")
    public String deshabilitar(ModelMap modelo, @PathVariable String id) {
        try {
            userServ.deshabilitar(id);
            return "redirect:/admin/dashboard";
        } catch (Exception e) {
            modelo.put("error", "No fue posible deshabilitar al usuario");
            return "inicioAdmin";
        }
    }

    @GetMapping("/cambiar_rol/{id}")
    public String cambiarRol(ModelMap modelo, @PathVariable String id) {
        try {
            userServ.cambiarRol(id);
            modelo.put("exito", "Rol modificado con Exito!");
            return "redirect:/admin/dashboard";
        } catch (Exception e) {
            modelo.put("error", "No fue posible reasignar el rol");
            return "inicioAdmin";
        }
    }
}
    
   