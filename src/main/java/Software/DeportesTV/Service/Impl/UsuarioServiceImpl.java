package Software.DeportesTV.Service.Impl;

import Software.DeportesTV.DTO.UsuarioDTO;
import Software.DeportesTV.Mapper.UsuarioMapper;
import Software.DeportesTV.Model.Usuario;
import Software.DeportesTV.Model.UsuarioEquipo;
import Software.DeportesTV.Repository.IUsuarioEquipoRepository;
import Software.DeportesTV.Repository.UsuarioRepository;
import Software.DeportesTV.Service.Interface.IUsuarioService;
import Software.DeportesTV.Service.Interface.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.ValidationException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements IUsuarioService {


    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private IUsuarioEquipoRepository usuarioEquipoRepository;

    @Override
    public Usuario findByUsername(String username) {
        return this.usuarioRepository.findByNombreUsuario(username);
    }

    @Override
    public Usuario signUp(Usuario usuarioDTO){

        Usuario existente = this.usuarioRepository.findByNombreUsuario(usuarioDTO.getNombreUsuario());
        if (existente != null) {
            throw new RuntimeException("El usuario ya existe");
        }

        return this.usuarioRepository.save(usuarioDTO);
    }

    @Override
    public Boolean login(Usuario usuarioDTO){
        Usuario existente = this.usuarioRepository.findByNombreUsuario(usuarioDTO.getNombreUsuario());
        if (existente != null) {
            return existente.getContrasena().equals(usuarioDTO.getContrasena());
        }
        return false;
    }

    @Override
    public Boolean seguirEquipo(Long idUsuario, Long idEquipo) {
        Usuario usuario = this.usuarioRepository.findById(idUsuario).orElse(null);
        if (usuario == null) {
            throw new RuntimeException("El usuario no existe");
        }
        //Equipo equipo = this.equipoRepository.findById(idEquipo).orElse(null);
        /*if (equipo == null) {
            throw new RuntimeException("El equipo no existe");
        }*/
        //usuario.getEquipos().add(equipo);
        UsuarioEquipo usuarioEquipo = new UsuarioEquipo();
        usuarioEquipo.setIdUsuario(idUsuario);
        usuarioEquipo.setIdEquipo(idEquipo);

        this.usuarioEquipoRepository.save(usuarioEquipo);
        return true;
    }

    @Override
    public List<Long> getEquiposSeguidos(Long idUsuario) {
        Usuario existente = this.usuarioRepository.findById(idUsuario).orElse(null);
        if (existente == null) {
            throw new RuntimeException("El usuario no existe");
        }
        List<UsuarioEquipo> usuarioEquipos = this.usuarioEquipoRepository.findByIdUsuario(idUsuario);
        return usuarioEquipos.stream().map(UsuarioEquipo::getIdEquipo).collect(Collectors.toList());
    }
}
