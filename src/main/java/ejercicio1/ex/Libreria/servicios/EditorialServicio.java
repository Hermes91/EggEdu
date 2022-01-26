package ejercicio1.ex.Libreria.servicios;

import ejercicio1.ex.Libreria.Errores.ErrorServicio;
import ejercicio1.ex.Libreria.entidades.Editorial;
import ejercicio1.ex.Libreria.repositorios.EditorialRepositorio;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//* @author HermesCh

@Service
public class EditorialServicio {

    @Autowired
    EditorialRepositorio editorialRepo;

    @Transactional
    public Editorial crear(String nombre) throws ErrorServicio {
          validar(nombre);
        Editorial editorial = new Editorial();
        editorial.setNombre(nombre);
        editorial.setAlta(true);
        return editorialRepo.save(editorial);
    }

    @Transactional
    public Editorial buscarId(String id) throws ErrorServicio {
        return editorialRepo.buscarPorId(id);
    }

    @Transactional
    public Editorial buscarNombre(String nombre) throws ErrorServicio {
        return editorialRepo.buscarPorNombre(nombre);
    }

    
     @Transactional
    public void eliminarAutor(String id) throws ErrorServicio {
        Editorial e = editorialRepo.buscarPorId(id);
        if (e != null) {
            e.setAlta(Boolean.FALSE);
       
        } else {
            throw new ErrorServicio("No se encontro el autor indicado");
    }
    }
 
///////////////////////////////////////////////
    
    public void validar(String nombre) throws ErrorServicio {
        if (nombre == null || nombre.isEmpty()) {
            throw new ErrorServicio("El nombre de la editorial no puede ser nulo");
        }
    }
}
