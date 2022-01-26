package ejercicio1.ex.Libreria.repositorios;
import ejercicio1.ex.Libreria.entidades.Libro;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

//* @author HermesCh

@Repository
public interface LibroRepositorio extends JpaRepository<Libro, String> {

    @Query("SELECT l FROM Libro l WHERE l.autor.nombre = :nombre")
    List<Libro> listarPorAutor(@Param("nombre") String Autor);

    @Query("SELECT l FROM Libro l WHERE l.editorial.nombre = :nombre")
    List<Libro> listarPorEditorial(@Param("nombre") String Editorial);

    @Query("SELECT l FROM Libro l WHERE l.id = :id")
    Libro buscarPorId(@Param("id") String id);

    @Query("SELECT l FROM Libro l WHERE l.titulo = :titulo " )
    Libro buscarPorTitulo(@Param("titulo") String titulo);

    @Query("SELECT l FROM Libro l WHERE l.alta = true ")
    List<Libro> buscarActivos();
}
