/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1.ex.Libreria.controladores;

import ejercicio1.ex.Libreria.entidades.Autor;
import ejercicio1.ex.Libreria.servicios.AutorServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/autor")
public class AutorControl {

    @Autowired
    private AutorServicio autorServ;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/agregar")
    public String formulario(ModelMap modelo) {
        return "form-autor";
    }

    @PostMapping("/agregar")
    public String guardar(ModelMap modelo, @RequestParam String nombre, @RequestParam String bio, @RequestParam MultipartFile archivo) {
        try {
            autorServ.crear(nombre, bio, archivo);
            modelo.put("exito", "Registro exitoso");
            return "form-autor";

        } catch (Exception e) {
            modelo.put("nombre", nombre);
            modelo.put("bio", bio);
            modelo.put("archivo", archivo);

            modelo.put("error", "datos insuficientes");
            return "form-autor";
        }
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USUARIO')")
    @GetMapping("/{id}")
    public String autor(ModelMap modelo, @PathVariable String id) {
        try {
            Autor autor = autorServ.buscarId(id);
            modelo.addAttribute("autor", autor);
            modelo.put("autor", autorServ.getOne(id));

            return "/view-autor";

        } catch (Exception e) {
            return "redirect:/";
        }

    }
}
