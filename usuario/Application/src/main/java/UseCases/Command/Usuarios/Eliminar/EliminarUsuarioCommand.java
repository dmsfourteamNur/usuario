package UseCases.Command.Usuarios.Eliminar;

import java.util.UUID;

import Dto.UsuarioDTO;
import Fourteam.mediator.Request;

public class EliminarUsuarioCommand implements Request<UsuarioDTO> {

	public UsuarioDTO usuarioDTO;

	public EliminarUsuarioCommand(UUID keyUSuario) {
		usuarioDTO = new UsuarioDTO();
		usuarioDTO.setKeyUsuario(keyUSuario);
	}
}
