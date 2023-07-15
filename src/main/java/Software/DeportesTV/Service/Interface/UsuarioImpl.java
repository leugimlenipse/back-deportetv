package Software.DeportesTV.Service.Interface;

import Software.DeportesTV.Model.Usuario;
import org.springframework.stereotype.Service;

@Service
public interface UsuarioImpl {

    // Encontrar los datos del usuario por el username
    Usuario findByUsername(String username);

    // Crear el usuario
    Usuario createUser(Usuario usuario);

    // Actualizar el usuario
    Usuario updateUser(Usuario usuario);

    // Eliminar usuario
    void deleteUser(Long idUsuario);

    // Buscar usuario
    Usuario findByUsernameAndPassword(String username, String password);

}
