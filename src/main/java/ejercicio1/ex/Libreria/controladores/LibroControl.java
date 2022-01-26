package ejercicio1.ex.Libreria.controladores;

import ejercicio1.ex.Libreria.Errores.ErrorServicio;
import ejercicio1.ex.Libreria.entidades.Autor;
import ejercicio1.ex.Libreria.entidades.Editorial;
import ejercicio1.ex.Libreria.entidades.Libro;
import ejercicio1.ex.Libreria.repositorios.AutorRepositorio;
import ejercicio1.ex.Libreria.repositorios.EditorialRepositorio;
import ejercicio1.ex.Libreria.servicios.LibroServicio;
import java.util.List;
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

//* @author HermesCh

@Controller
@RequestMapping("/libro")
public class LibroControl {

    @Autowired
    private AutorRepositorio autorRepo;
    @Autowired
    private EditorialRepositorio editRepo;
    @Autowired
    private LibroServicio libroServ;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USUARIO')")
    @GetMapping("/lista")
    public String lista(ModelMap modelo) {
        List<Libro> librosLista = libroServ.listarTodos();
        modelo.addAttribute("libros", librosLista);

        return "list-libro";
    }

   
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/agregar")
    public String formulario(ModelMap modelo) {
        List<Autor> autores = autorRepo.findAll();
        modelo.put("autores", autores);
        List<Editorial> editoriales = editRepo.findAll();
        modelo.put("editoriales", editoriales);
        return "form-libro";
    }

    @PostMapping("/registrar")
    public String registrar(ModelMap modelo, @RequestParam(required = false) String titulo, @RequestParam(required = false) Integer anio, @RequestParam(required = false) Integer ejemplares, @RequestParam(required = false) Integer ejemplaresPrestados, @RequestParam(required = false) String idAutor, @RequestParam(required = false) String idEditorial, @RequestParam MultipartFile archivo,@RequestParam(required = false) String review) {
        try {
            libroServ.guardarLibro(titulo, anio, ejemplares, ejemplaresPrestados, idAutor, idEditorial, archivo,review);
            modelo.put("exito", "Registro exitoso");
            return "form-libro";

        } catch (ErrorServicio e) {
            List<Autor> autores = autorRepo.findAll();
            modelo.put("autores", autores);
            List<Editorial> editoriales = editRepo.findAll();
            modelo.put("editoriales", editoriales);
            modelo.put("titulo", titulo);
            modelo.put("anio", anio);
            modelo.put("ejemplares", ejemplares);
            modelo.put("ejemplaresPrestados", ejemplaresPrestados);
            modelo.put("archivo", archivo);
            modelo.put("review", review);

            modelo.put("error", e.getMessage());

            return "form-libro";
        }
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/modificar/{id}")
    public String modificar(ModelMap modelo, @PathVariable String id) {
        List<Autor> autores = autorRepo.findAll();
        modelo.put("autores", autores);
        List<Editorial> editoriales = editRepo.findAll();
        modelo.put("editoriales", editoriales);
        modelo.put("libro", libroServ.getOne(id));
        return "form-libro-modif.html";
    }

    @PostMapping("/modificar/{id}")
    public String modificar(ModelMap modelo, @RequestParam(required = false) String id, @RequestParam(required = false) String titulo, @RequestParam(required = false) Integer anio, @RequestParam(required = false) Integer ejemplares, @RequestParam(required = false) Integer ejemplaresPrestados, @RequestParam(required = false) String idAutor, @RequestParam(required = false) String idEditorial, @RequestParam(required = false) MultipartFile archivo,@RequestParam(required = false) String review) throws Exception {
        try {
            libroServ.modificarLibro(id, titulo, anio, ejemplares, ejemplaresPrestados, ejemplaresPrestados, idAutor, idEditorial, archivo,review);

            modelo.put("exito", "Modificacion Exitosa!");
            return "form-libro-modif";

        } catch (Exception e) {

            List<Autor> autores = autorRepo.findAll();
            modelo.put("autores", autores);
            List<Editorial> editoriales = editRepo.findAll();
            modelo.put("editoriales", editoriales);
            modelo.put("titulo", titulo);
            modelo.put("anio", anio);
            modelo.put("ejemplares", ejemplares);
            modelo.put("ejemplaresPrestados", ejemplaresPrestados);
            modelo.put("archivo", archivo);
            modelo.put("review", review);

            modelo.put("error", "no se han podido cargar los datos");
            return "form-libro-modif";
        }
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/baja/{id}")
    public String baja(@PathVariable String id) {

        try {
            libroServ.baja(id);
            return "redirect:/libro/lista";
        } catch (Exception e) {
            return "redirect:/";
        }
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/alta/{id}")
    public String alta(@PathVariable String id) {

        try {
            libroServ.alta(id);
            return "redirect:/libro/lista";
        } catch (Exception e) {
            return "redirect:/";
        }
    }
    
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USUARIO')")
    @GetMapping("/{id}")
    public String autor(ModelMap modelo, @PathVariable String id) {
        try {
            Libro libro =libroServ.buscarId(id);
           
            modelo.addAttribute("libro", libro);
            modelo.put("libro",libroServ.getOne(id));

            return "/view-libro";

        } catch (Exception e) {
            return "redirect:/";
        }

    }
}
