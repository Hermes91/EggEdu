
package ejercicio1.ex.Libreria.controladores;

import ejercicio1.ex.Libreria.servicios.EditorialServicio;
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
@RequestMapping("/editorial")
public class EditorialControl {

    @Autowired
    private EditorialServicio editServ;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/agregar")
    public String formulario() {
        return "form-editorial";
    }

    @PostMapping("/agregar")
    public String guardar(ModelMap modelo, @RequestParam String nombre) {
        try {
            editServ.crear(nombre);
            modelo.put("exito", "Registro exitoso");
            return "form-autor";

        } catch (Exception e) {
            modelo.put("nombre", nombre);

            modelo.put("error", "datos insuficientes");
            return "form-autor";
        }
    }
}
