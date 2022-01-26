package ejercicio1.ex.Libreria.repositorios;

import ejercicio1.ex.Libreria.entidades.Autor;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

//* @author HermesCh

@Repository
public interface AutorRepositorio extends JpaRepository<Autor, String> {

    @Query("SELECT a FROM Autor a LEFT JOIN Libro l ON a.id = l.autor.id WHERE l.editorial.nombre = :nombre")
    List<Autor> listarPorEditorial(@Param("nombre") String Editorial);

    @Query("SELECT a FROM Autor a WHERE a.id = :id")
    Autor buscarPorId(@Param("id") String id);

    @Query("SELECT a FROM Autor a WHERE a.nombre = :nombre")
    Autor buscarPorNombre(@Param("nombre") String nombre);

}
