package UseCases.Command.Usuarios.Crear;

import java.util.UUID;

import Dto.UsuarioDTO;
import Fourteam.mediator.Request;

public class CrearUsuarioCommand implements Request<UsuarioDTO> {

	public UUID keyUsuario;
	public String usuario;
	public String password;
	public String tipo;
	public String estado;

	public CrearUsuarioCommand(UsuarioDTO usuarioDTO) {
		this.keyUsuario = usuarioDTO.keyUsuario;
		this.usuario = usuarioDTO.usuario;
		this.password = usuarioDTO.password;
		this.tipo = usuarioDTO.tipo;
		this.estado = usuarioDTO.estado;
	}
}