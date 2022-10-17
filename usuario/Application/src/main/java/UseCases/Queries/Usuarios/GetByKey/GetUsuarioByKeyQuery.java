package UseCases.Queries.Usuarios.GetByKey;

import java.util.UUID;

import Dto.UsuarioDTO;
import Fourteam.mediator.Request;

public class GetUsuarioByKeyQuery implements Request<UsuarioDTO> {

	public UUID Key;

	public GetUsuarioByKeyQuery(UUID Key) {
		this.Key = Key;
	}
}
