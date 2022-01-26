package ejercicio1.ex.Libreria.controladores;

import ejercicio1.ex.Libreria.Errores.ErrorServicio;
import ejercicio1.ex.Libreria.entidades.Autor;
import ejercicio1.ex.Libreria.entidades.Libro;
import ejercicio1.ex.Libreria.servicios.AutorServicio;
import ejercicio1.ex.Libreria.servicios.LibroServicio;
import java.util.logging.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.logging.Logger;
      
//* @author HermesCh


@Controller
@RequestMapping("/foto")
public class FotoControl {

    @Autowired
    private AutorServicio autorServ;
    
      @Autowired
    private LibroServicio libroServ;

      
// portada de libro
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USUARIO')")
    @GetMapping("/libro/{id}")
    public ResponseEntity<byte[]> portadaLibro(@PathVariable String id) {

        try {
            Libro libro = libroServ.buscarId(id);
            if (libro.getPortada()== null) {
                throw new ErrorServicio("No se encontro una portada asignada");
            }

            byte[] portada = libro.getPortada().getContenido();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG);

            return new ResponseEntity<>(portada, headers, HttpStatus.OK);
        } catch (ErrorServicio ex) {
            Logger.getLogger(FotoControl.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
// foto del autor    
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USUARIO')")
    @GetMapping("/autor/{id}")
    public ResponseEntity<byte[]> fotoAutor(@PathVariable String id) {

        try {
            Autor autor = autorServ.buscarId(id);
            if (autor.getFoto() == null) {
                throw new ErrorServicio("No se encontro una foto asignada");
            }

            byte[] foto = autor.getFoto().getContenido();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG);

            return new ResponseEntity<>(foto, headers, HttpStatus.OK);
        } catch (ErrorServicio ex) {
            Logger.getLogger(FotoControl.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
