package ejercicio1.ex.Libreria.servicios;

import ejercicio1.ex.Libreria.Errores.ErrorServicio;
import ejercicio1.ex.Libreria.entidades.Autor;
import ejercicio1.ex.Libreria.entidades.Foto;
import ejercicio1.ex.Libreria.repositorios.AutorRepositorio;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

//* @author HermesCh

@Service
public class AutorServicio {

    @Autowired
    AutorRepositorio autorRepo;
    @Autowired
    FotoServicio fotoServ;

    @Transactional
    public void crear(String nombre, String bio, MultipartFile archivo) throws ErrorServicio {

        validar(nombre, bio);
        Autor autor = new Autor();
        autor.setNombre(nombre);

        autor.setBio(bio);
        autor.setAlta(true);

        Foto foto = fotoServ.guardar(archivo);
        autor.setFoto(foto);

        autorRepo.save(autor);
    }
    
///////////////////////////////////////////////
    
    @Transactional
    public Autor buscarId(String id) throws ErrorServicio {
        return autorRepo.buscarPorId(id);
    }

    @Transactional
    public Autor buscarNombre(String nombre) throws ErrorServicio {
        return autorRepo.buscarPorNombre(nombre);
    }

    @Transactional
    public void eliminarAutor(String id) throws ErrorServicio {
        Autor a = autorRepo.buscarPorId(id);
        if (a != null) {
            a.setAlta(Boolean.FALSE);

        } else {
            throw new ErrorServicio("No se encontro el autor indicado");
        }
    }

    @Transactional
    public Autor getOne(String id) {
        return autorRepo.getById(id);
    }

    @Transactional
    public List<Autor> listarAutores() {
        return autorRepo.findAll();
    }

///////////////////////////////////////////////
    
    public void validar(String nombre, String bio) throws ErrorServicio {
        if (nombre == null || nombre.isEmpty()) {
            throw new ErrorServicio("El nombre del autor no puede ser nulo");
        }
        if (bio == null || bio.isEmpty()) {
            throw new ErrorServicio("La bio no puede estar vacia");
        }
    }
}
