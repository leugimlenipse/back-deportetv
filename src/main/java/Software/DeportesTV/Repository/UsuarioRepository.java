package Software.DeportesTV.Repository;

import Software.DeportesTV.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByNombreUsuario(String username);

    @Query(value = "SELECT us FROM Usuario us " +
                   "WHERE us.nombreUsuario = :username " +
                   "AND us.id <> :id")
    Usuario validateUsername(String username, Long id);

    Usuario findByNombreUsuarioAndContrasena(String username, String password);

}
