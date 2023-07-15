package Software.DeportesTV.Mapper;

import Software.DeportesTV.DTO.UsuarioDTO;
import Software.DeportesTV.Model.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UsuarioMapper {

    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    // Entidad a DTO
    Usuario toUsuario(UsuarioDTO usuarioDTO);

    // DTO a Entidad
    UsuarioDTO toUsuarioDTO(Usuario usuario);

}
