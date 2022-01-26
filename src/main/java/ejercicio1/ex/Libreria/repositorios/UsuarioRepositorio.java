
package ejercicio1.ex.Libreria.repositorios;

import ejercicio1.ex.Libreria.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

//* @author HermesCh

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, String>{
    
    @Query("SELECT c FROM Usuario c WHERE c.mail= :mail")
     Usuario buscarPorMail (@Param("mail") String mail);
    
}


