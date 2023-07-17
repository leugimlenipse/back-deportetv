package Software.DeportesTV.Service.Interface;

import Software.DeportesTV.Model.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IUsuarioService {

    // Encontrar los datos del usuario por el username
    Usuario findByUsername(String username);

    // Crear el usuario
    Usuario signUp(Usuario usuarioDTO);

    Boolean login(Usuario usuarioDTO);

    Boolean seguirEquipo(Long idUsuario, Long idEquipo);

    List<Long> getEquiposSeguidos(Long idUsuario);
}
