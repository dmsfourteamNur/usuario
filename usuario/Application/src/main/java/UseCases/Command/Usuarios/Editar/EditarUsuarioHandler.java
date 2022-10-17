package UseCases.Command.Usuarios.Editar;

import Dto.UsuarioDTO;
import Factories.IUsuarioFactory;
import Fourteam.http.HttpStatus;
import Fourteam.http.Exception.HttpException;
import Fourteam.mediator.RequestHandler;
import Model.Usuarios.Usuario;
import Repositories.IUnitOfWork;
import Repositories.IUsuarioRepository;

public class EditarUsuarioHandler
		implements RequestHandler<EditarUsuarioCommand, UsuarioDTO> {

	private IUsuarioFactory iUsuarioFactory;
	private IUsuarioRepository iUsuarioRepository;
	private IUnitOfWork unitOfWor;

	public EditarUsuarioHandler(
			IUsuarioFactory iUsuarioFactory,
			IUsuarioRepository iUsuarioRepository,
			IUnitOfWork unitOfWor) {
		this.iUsuarioFactory = iUsuarioFactory;
		this.iUsuarioRepository = iUsuarioRepository;
		this.unitOfWor = unitOfWor;
	}

	@Override
	public UsuarioDTO handle(EditarUsuarioCommand request) throws Exception {
		Usuario usuario = iUsuarioRepository.FindByKey(request.usuarioDTO.keyUsuario);

		if (usuario == null) {
			throw new HttpException(HttpStatus.BAD_REQUEST, "usuario no encontrado");
		}
		usuario.usuario = request.usuarioDTO.getUsuario();
		usuario.password = request.usuarioDTO.getPassword();
		usuario.tipo = request.usuarioDTO.getTipo();
		usuario.estado = request.usuarioDTO.getEstado();
		// iUsuarioRepository.Update(usuario);

		UsuarioDTO vueloDto = new UsuarioDTO();
		vueloDto.setUsuario(usuario.getUsuario());
		vueloDto.setPassword(usuario.getPassword());
		vueloDto.setTipo(usuario.getTipo());
		vueloDto.setEstado(usuario.getEstado());

		iUsuarioRepository.Update(usuario);

		return vueloDto;

	}
}
