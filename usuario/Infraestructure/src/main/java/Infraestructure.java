
import Context.IWriteDbContext;
import Context.MongoDB.WriteDbContext;
import Fourteam.config.Config;
import Fourteam.extensions.IServiceCollection;
import Repositories.IUnitOfWork;
import Repositories.IUsuarioRepository;
import Repository.UsuarioRepository;

public class Infraestructure {

	public static void AddInfraestructure() {
		IServiceCollection.AddMediator();
		IServiceCollection.AddScoped(IWriteDbContext.class, WriteDbContext.class);
		IServiceCollection.AddScoped(IUnitOfWork.class, UnitOfWork.class);
		IServiceCollection.AddScoped(IUsuarioRepository.class, UsuarioRepository.class);
		// IServiceCollection.AddScoped(ITripulacionRepository.class,
		// TripulacionRepository.class);
		// IServiceCollection.AddScoped(IAeronaveRepository.class,
		// AeronaveRepository.class);

		Application.AddApplication();
		AddRabbitMq();
	}

	private static void AddRabbitMq() {
		IServiceCollection.AddMassTransit(config -> {
			// config.AddConsumer(UsuarioChangeConsumer.class);
			config.UsingRabbitMq((context, cfg) -> {
				cfg.Host = Config.getProperty("rabit.host");
				cfg.User = Config.getProperty("rabit.user");
				cfg.Password = Config.getProperty("rabit.pass");
			});
		});
	}

}
