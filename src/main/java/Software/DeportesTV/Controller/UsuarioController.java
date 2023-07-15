package Software.DeportesTV.Controller;

import Software.DeportesTV.Model.Usuario;
import Software.DeportesTV.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/findByUsername/{username}")
    public ResponseEntity<Usuario> findByIdUsername(
            @PathVariable("username") String username
    ) {

        Usuario usuario = this.usuarioRepository.findByNombreUsuario(username);

        if (usuario == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Usuario> create(
            @RequestBody Usuario usuarioDTO
    ) {
        Usuario usuario = this.usuarioRepository.save(usuarioDTO);
        //UsuarioDTO newUsuarioDto = UsuarioMapper.INSTANCE.toUsuarioDTO(usuario);


        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }
}
