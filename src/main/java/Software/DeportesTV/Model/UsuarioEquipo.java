package Software.DeportesTV.Model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "usuario_equipo", schema = "public")
public class UsuarioEquipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(name = "id_equipo")
    private Long idEquipo;

}
