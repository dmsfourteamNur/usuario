package UseCases.Command.Usuarios.Crear;

import Factories.IUsuarioFactory;
import Fourteam.mediator.RequestHandler;
import Model.Usuarios.Usuario;
import Repositories.IUnitOfWork;
import Repositories.IUsuarioRepository;

public class CrearUsuarioHandler implements RequestHandler<CrearUsuarioCommand, Usuario> {
	private IUsuarioFactory iUsuarioFactory;
	private IUsuarioRepository iUsuarioRepository;
	private IUnitOfWork unitOfWor;

	public CrearUsuarioHandler(
			IUsuarioFactory iUsuarioFactory,
			IUsuarioRepository iUsuarioRepository,
			IUnitOfWork unitOfWor) {
		this.iUsuarioFactory = iUsuarioFactory;
		this.iUsuarioRepository = iUsuarioRepository;
		this.unitOfWor = unitOfWor;
	}

	@Override
	public Usuario handle(CrearUsuarioCommand arg0) throws Exception {
		Usuario usuario = iUsuarioFactory.Create(arg0.usuario, arg0.password, arg0.tipo, arg0.estado);
		iUsuarioRepository.Create(usuario);
		unitOfWor.commit();
		return usuario;
	}
}
