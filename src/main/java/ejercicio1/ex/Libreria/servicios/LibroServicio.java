package ejercicio1.ex.Libreria.servicios;

import ejercicio1.ex.Libreria.Errores.ErrorServicio;
import ejercicio1.ex.Libreria.entidades.Autor;
import ejercicio1.ex.Libreria.entidades.Editorial;
import ejercicio1.ex.Libreria.entidades.Foto;
import ejercicio1.ex.Libreria.entidades.Libro;
import ejercicio1.ex.Libreria.repositorios.AutorRepositorio;
import ejercicio1.ex.Libreria.repositorios.EditorialRepositorio;
import ejercicio1.ex.Libreria.repositorios.LibroRepositorio;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

//* @author HermesCh
@Service
public class LibroServicio {

    @Autowired
    AutorServicio as;
    @Autowired
    EditorialServicio es;
    @Autowired
    FotoServicio fotoServ;

    @Autowired
    LibroRepositorio libroRepo;
    @Autowired
    AutorRepositorio autorRepo;
    @Autowired
    EditorialRepositorio editRepo;

    @Transactional
    public Libro guardarLibro(String titulo, Integer anio, Integer ejemplares, Integer ejemplaresPrestados, String idAutor, String idEditorial, MultipartFile archivo, String review) throws ErrorServicio {

        Autor autor = autorRepo.getById(idAutor);

        Editorial editorial = editRepo.getById(idEditorial);

        validar(titulo, anio, ejemplares, ejemplaresPrestados, autor, editorial);
        Libro libro = new Libro();

        Long isbn = (long) Math.floor(Math.random() * 9000000000000L) + 1000000000000L;

        libro.setAutor(autor);
        libro.setEditorial(editorial);
        libro.setIsbn(isbn);
        libro.setTitulo(titulo);
        libro.setAnio(anio);
        libro.setEjemplares(ejemplares);
        libro.setEjemplaresPrestados(ejemplaresPrestados);
        Integer ejemplaresRestantes = libro.getEjemplares() - libro.getEjemplaresPrestados();
        libro.setEjemplaresRestantes(ejemplaresRestantes);
        libro.setAlta(true);

        Foto portada = fotoServ.guardar(archivo);
        libro.setPortada(portada);
        libro.setReview(review);

        return libroRepo.save(libro);
    }

    @Transactional
    public Libro getOne(String id) {
        return libroRepo.getById(id);
    }

    @Transactional
    public Libro buscarId(String id) throws ErrorServicio {
        return libroRepo.getById(id);
    }

    @Transactional
    public void modificarLibro(String id, String titulo, Integer anio, Integer ejemplares, Integer ejemplaresPrestados, Integer ejemplaresRestantes, String idAutor, String idEditorial, MultipartFile archivo, String review) throws ErrorServicio {
        Editorial editorial = editRepo.getById(idEditorial);
        Autor autor = autorRepo.getById(idAutor);
        validar(titulo, anio, ejemplares, ejemplaresPrestados, autor, editorial);

        Libro l = libroRepo.buscarPorId(id);
        if (l != null) {
            Libro libro = libroRepo.buscarPorId(id);

            libro.setTitulo(titulo);
            libro.setAnio(anio);
            libro.setEjemplares(ejemplares);
            libro.setEjemplaresPrestados(ejemplaresPrestados);
            ejemplaresRestantes = libro.getEjemplares() - libro.getEjemplaresPrestados();
            libro.setEjemplaresRestantes(ejemplaresRestantes);
            libro.setAutor(autor);
            libro.setEditorial(editorial);

            Foto portada = fotoServ.guardar(archivo);
            libro.setPortada(portada);
            libro.setReview(review);

            libroRepo.save(libro);
        } else {
            throw new ErrorServicio("No se encontro el libro indicado");
        }
    }

///////////////////////////////////////////////
    
    @Transactional
    public List<Libro> listarActivos() {
        return libroRepo.buscarActivos();
    }

    @Transactional
    public List<Libro> listarTodos() {
        return libroRepo.findAll(Sort.by(Sort.Direction.ASC, "titulo"));
    }

    @Transactional
    public Libro alta(String id) {
        Libro libro = libroRepo.getOne(id);
        libro.setAlta(true);
        return libroRepo.save(libro);
    }

    @Transactional
    public Libro baja(String id) {
        Libro libro = libroRepo.getOne(id);
        libro.setAlta(false);
        return libroRepo.save(libro);
    }

///////////////////////////////////////////////
    
    public void validar(String titulo, Integer anio, Integer ejemplares, Integer ejemplaresPrestados, Autor autor, Editorial editorial) throws ErrorServicio {
        if (titulo == null || titulo.isEmpty()) {
            throw new ErrorServicio("El titulo del libro no puede ser nulo");
        }
        if (anio == null || anio <= 1800 || anio.equals(0)) {
            throw new ErrorServicio("El año ingresado no es correcto");
        }
        if (ejemplares == null || ejemplares.equals(0)) {
            throw new ErrorServicio("El número de ejemplares no puede ser nulo");
        }
        if (ejemplaresPrestados == null || ejemplaresPrestados > ejemplares) {
            throw new ErrorServicio("El valor de ejemplares prestados no puede ser nulo ni mayor a la cantidad total de ejemplares");
        }
        if (autor == null) {
            throw new ErrorServicio("No se encontro el autor solicitado");
        }
        if (editorial == null) {
            throw new ErrorServicio("No se encontro la editorial solicitada");
        }
    }
}
