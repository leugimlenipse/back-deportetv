package Software.DeportesTV.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class UsuarioDTO {

    private Long id;

    private String nombre;

    private String apellido;

    private String nombreUsuario;

    private String contrasena;

    private Date fechaDesde;

    private Date fechaHasta;

}
