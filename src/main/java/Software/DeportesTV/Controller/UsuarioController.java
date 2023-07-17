package Software.DeportesTV.Controller;

import Software.DeportesTV.DTO.UsuarioDTO;
import Software.DeportesTV.Mapper.UsuarioMapper;
import Software.DeportesTV.Model.Usuario;
import Software.DeportesTV.Repository.UsuarioRepository;
import Software.DeportesTV.Service.Interface.IUsuarioService;
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
    @Autowired
    private IUsuarioService usuarioService;

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

    @PostMapping("/signUp")
    public ResponseEntity<Usuario> signUp(
            @RequestBody Usuario usuarioDTO) {
        Usuario usuario = this.usuarioService.signUp(usuarioDTO);

        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @GetMapping("/login")
    public ResponseEntity<Boolean> login(
            @RequestBody Usuario usuarioDTO) {
        Boolean logged = this.usuarioService.login(usuarioDTO);

        return new ResponseEntity<>(logged, HttpStatus.OK);
    }

    @PostMapping("/seguirEquipo")
    public ResponseEntity<Boolean> seguirEquipo(@RequestParam("idUsuario") Long idUsuario,
                                                @RequestParam("idEquipo") Long idEquipo) {
        Boolean seguido = this.usuarioService.seguirEquipo(idUsuario, idEquipo);
        return new ResponseEntity<>(seguido, HttpStatus.OK);
    }

    @GetMapping("/getEquiposSeguidos")
    public ResponseEntity<List<Long>> getEquiposSeguidos(@RequestParam("idUsuario") Long idUsuario) {
        List<Long> equiposSeguidos = this.usuarioService.getEquiposSeguidos(idUsuario);
        return new ResponseEntity<>(equiposSeguidos, HttpStatus.OK);
    }
}
