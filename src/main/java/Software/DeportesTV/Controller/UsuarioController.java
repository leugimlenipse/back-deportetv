package Software.DeportesTV.Controller;

import Software.DeportesTV.Model.Usuario;
import Software.DeportesTV.Repository.UsuarioRepository;
import Software.DeportesTV.Service.Impl.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioServiceImpl usuarioService;

    @GetMapping("/findByUsername/{username}")
    public ResponseEntity<Usuario> findByIdUsername(
            @PathVariable("username") String username
    ) {

        Usuario usuario = this.usuarioService.findByUsername(username);

        if (usuario == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @GetMapping("/login")
    public ResponseEntity<Usuario> loginUser(
            @PathParam("username") String username,
            @PathParam("password") String password
    ){
        Usuario usuario = this.usuarioService.findByUsernameAndPassword(username, password);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }


    @PostMapping("/create")
    public ResponseEntity<Usuario> createUser(
            @RequestBody Usuario usuario
    ) {

        return new ResponseEntity<>(this.usuarioService.createUser(usuario), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Usuario> updateUser(
            @RequestBody Usuario usuario
    ) {
        return new ResponseEntity<>(this.usuarioService.updateUser(usuario)
        , HttpStatus.OK);
    }

    @DeleteMapping("/delete/{idUsuario}")
    public ResponseEntity<Boolean> deleteUser(
            @PathVariable("idUsuario") Long idUsuario
    ) {
        this.usuarioService.deleteUser(idUsuario);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }



}
