package UseCases.Queries.Usuarios.GetAll;

import java.util.ArrayList;
import java.util.List;

import Dto.UsuarioDTO;
import Fourteam.mediator.RequestHandler;
import Model.Usuarios.Usuario;
import Repositories.IUsuarioRepository;

public class GetAllUsuarioHandler implements RequestHandler<GetAllUsuarioQuery, List<UsuarioDTO>> {

	private IUsuarioRepository iUsuarioRepository;

	public GetAllUsuarioHandler(IUsuarioRepository iUsuarioRepository) {
		this.iUsuarioRepository = iUsuarioRepository;
	}

	@Override
	public List<UsuarioDTO> handle(GetAllUsuarioQuery request) throws Exception {

		List<Usuario> lista = iUsuarioRepository.GetAll();
		List<UsuarioDTO> resp = new ArrayList<>();

		for (Usuario vuelo : lista) {
			UsuarioDTO vueloDto = new UsuarioDTO();
			vueloDto.setKeyUsuario(vuelo.keyUsuario);
			vueloDto.setUsuario(vuelo.getUsuario());
			vueloDto.setPassword(vuelo.getPassword());
			vueloDto.setTipo(vuelo.getTipo());
			vueloDto.setEstado(vuelo.getEstado());

			resp.add(vueloDto);

		}

		return resp;
	}
}