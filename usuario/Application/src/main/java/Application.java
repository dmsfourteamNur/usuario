import Factories.IUsuarioFactory;
import Factories.UsuarioFactory;
import Fourteam.extensions.IServiceCollection;
import Fourteam.mediator.IMediator;
import UseCases.Command.Usuarios.Crear.CrearUsuarioHandler;
import UseCases.Command.Usuarios.Editar.EditarUsuarioHandler;
import UseCases.Command.Usuarios.Eliminar.EliminarUsuarioHandler;
import UseCases.Queries.Usuarios.GetAll.GetAllUsuarioHandler;
import UseCases.Queries.Usuarios.GetByKey.GetUsuarioByKeyHandler;

public class Application {

	public static void AddApplication() {
		// USE CASE: VUELO
		IMediator.registerHandler(GetAllUsuarioHandler.class);
		IMediator.registerHandler(GetUsuarioByKeyHandler.class);
		IMediator.registerHandler(CrearUsuarioHandler.class);
		IMediator.registerHandler(EditarUsuarioHandler.class);
		IMediator.registerHandler(EliminarUsuarioHandler.class);

		// publish
		// IMediator.registerHandler(PublishIntegrationEventWhenVueloCreadoHandler.class);

		// Transient
		IServiceCollection.AddTransient(IUsuarioFactory.class, UsuarioFactory.class);
		Domain.addDomain();
	}
}
