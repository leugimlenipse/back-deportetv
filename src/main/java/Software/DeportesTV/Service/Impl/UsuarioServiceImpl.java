package Software.DeportesTV.Service.Impl;

import Software.DeportesTV.Model.Usuario;
import Software.DeportesTV.Repository.UsuarioRepository;
import Software.DeportesTV.Service.Interface.UsuarioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioImpl {


    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario findByUsername(String username) {
        return this.usuarioRepository.findByNombreUsuario(username);
    }

    @Override
    public Usuario createUser(Usuario usuario) {
        return this.usuarioRepository.save(usuario);
    }
}
