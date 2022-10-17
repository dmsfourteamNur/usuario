package UseCases.Command.Usuarios.Editar;

import java.util.UUID;

import Dto.UsuarioDTO;
import Fourteam.mediator.Request;

public class EditarUsuarioCommand implements Request<UsuarioDTO> {

	public UsuarioDTO usuarioDTO;

	public EditarUsuarioCommand(UUID key) {
		this.usuarioDTO = new UsuarioDTO();
		this.usuarioDTO.setKeyUsuario(key);
	}
}
