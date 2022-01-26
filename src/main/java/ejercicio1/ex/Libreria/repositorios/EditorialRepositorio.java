package ejercicio1.ex.Libreria.repositorios;

import ejercicio1.ex.Libreria.entidades.Editorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

//* @author HermesCh

@Repository
public interface EditorialRepositorio extends JpaRepository<Editorial, String> {

    @Query("SELECT e FROM Editorial e WHERE e.id = :id")
    Editorial buscarPorId(@Param("id") String id);

    @Query("SELECT e FROM Editorial e WHERE e.nombre = :nombre")
    Editorial buscarPorNombre(@Param("nombre") String nombre);
}
