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
        if (this.findByUsername(usuario.getNombreUsuario()) != null){
            throw new RuntimeException("El usuario ya existe");
        }
        return this.usuarioRepository.save(usuario);
    }

    @Override
    public Usuario updateUser(Usuario usuario) {

        if (this.usuarioRepository.findById(usuario.getId()).isEmpty()){
            throw new RuntimeException("El usuario no existe");
        }

        if (this.usuarioRepository.validateUsername(usuario.getNombreUsuario()
                , usuario.getId()) != null){
            throw new RuntimeException("El usuario ya existe");
        }
        return this.usuarioRepository.save(usuario);
    }

    @Override
    public void deleteUser(Long idUsuario) {

        Usuario usuario = this.usuarioRepository.findById(idUsuario).get();
        if(usuario == null){
            throw new RuntimeException("El usuario no existe");
        }
        this.usuarioRepository.delete(this.usuarioRepository.findById(idUsuario).get());
    }

    @Override
    public Usuario findByUsernameAndPassword(String username, String password) {

        Usuario usuario = this.usuarioRepository.findByNombreUsuarioAndContrasena(username, password);

        if (usuario == null){
            throw new RuntimeException("Los datos son incorrectos");
        }
        return usuario;
    }

}
