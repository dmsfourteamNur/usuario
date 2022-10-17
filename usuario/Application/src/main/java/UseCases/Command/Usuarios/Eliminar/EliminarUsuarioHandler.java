package UseCases.Command.Usuarios.Eliminar;

import Factories.IUsuarioFactory;
import Fourteam.http.HttpStatus;
import Fourteam.http.Exception.HttpException;
import Fourteam.mediator.RequestHandler;
import Model.Usuarios.Usuario;
import Repositories.IUnitOfWork;
import Repositories.IUsuarioRepository;

public class EliminarUsuarioHandler
		implements RequestHandler<EliminarUsuarioCommand, Usuario> {

	private IUsuarioFactory iUsuarioFactory;
	private IUsuarioRepository iUsuarioRepository;
	private IUnitOfWork unitOfWor;

	public EliminarUsuarioHandler(
			IUsuarioFactory iUsuarioFactory,
			IUsuarioRepository iUsuarioRepository,
			IUnitOfWork unitOfWor) {
		this.iUsuarioFactory = iUsuarioFactory;
		this.iUsuarioRepository = iUsuarioRepository;
		this.unitOfWor = unitOfWor;
	}

	@Override
	public Usuario handle(EliminarUsuarioCommand request) throws Exception {
		Usuario usuario = iUsuarioRepository.FindByKey(request.usuarioDTO.keyUsuario);
		if (usuario == null) {
			throw new HttpException(HttpStatus.BAD_REQUEST, "usuario no encontrado");
		}
		return iUsuarioRepository.Delete(usuario);
	}
}
