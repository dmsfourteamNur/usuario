package UseCases.Queries.Usuarios.GetByKey;

import Dto.UsuarioDTO;
import Fourteam.http.HttpStatus;
import Fourteam.http.Exception.HttpException;
import Fourteam.mediator.RequestHandler;
import Model.Usuarios.Usuario;
import Repositories.IUsuarioRepository;

public class GetUsuarioByKeyHandler implements RequestHandler<GetUsuarioByKeyQuery, UsuarioDTO> {

	private IUsuarioRepository iUsuarioRepository;

	public GetUsuarioByKeyHandler(IUsuarioRepository iUsuarioRepository) {
		this.iUsuarioRepository = iUsuarioRepository;
	}

	@Override
	public UsuarioDTO handle(GetUsuarioByKeyQuery request) throws Exception {
		Usuario vuelo = iUsuarioRepository.FindByKey(request.Key);

		if (vuelo == null) {
			throw new HttpException(HttpStatus.BAD_REQUEST, "vuelo no encontrada");
		}

		UsuarioDTO usuarioDTO = new UsuarioDTO();
		usuarioDTO.setKeyUsuario(vuelo.keyUsuario);
		usuarioDTO.setUsuario(vuelo.getUsuario());
		usuarioDTO.setPassword(vuelo.getPassword());
		usuarioDTO.setTipo(vuelo.getTipo());
		usuarioDTO.setEstado(vuelo.getEstado());

		return usuarioDTO;
	}
}