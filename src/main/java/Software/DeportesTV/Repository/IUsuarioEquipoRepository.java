package Software.DeportesTV.Repository;

import Software.DeportesTV.Model.UsuarioEquipo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUsuarioEquipoRepository extends JpaRepository<UsuarioEquipo, Long> {

    List<UsuarioEquipo> findByIdUsuario(Long idUsuario);
}
