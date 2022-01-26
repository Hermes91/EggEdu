
package ejercicio1.ex.Libreria.repositorios;

import ejercicio1.ex.Libreria.entidades.Foto;
import org.springframework.data.jpa.repository.JpaRepository;

//* @author HermesCh

public interface FotoRepositorio extends JpaRepository<Foto, String> {
    
}
