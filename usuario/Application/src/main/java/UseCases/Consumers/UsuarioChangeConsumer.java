// package UseCases.Consumers;

// import Factories.IUsuarioFactory;
// import Fourteam.massTransit.IConsumer;
// import Model.Aeronaves.Aeronave;
// import Model.Usuarios.Usuario;
// import Repositories.IUnitOfWork;
// import Repositories.IUsuarioRepository;

// public class UsuarioChangeConsumer extends
// IConsumer<IntegrationEvents.UsuarioChangeConsumer> {

// private static String QueueName = "[Vuelo]-aeronave-change";

// private IUsuarioFactory iUsuarioFactory;
// private IUsuarioRepository iUsuarioRepository;
// private IUnitOfWork unitOfWor;

// public UsuarioChangeConsumer(
// IUsuarioFactory iUsuarioFactory,
// IUsuarioRepository iUsuarioRepository,
// IUnitOfWork unitOfWor) {
// this.iUsuarioFactory = iUsuarioFactory;
// this.iUsuarioRepository = iUsuarioRepository;
// this.unitOfWor = unitOfWor;
// }

// @Override
// public void Consume(IntegrationEvents.UsuarioChangeConsumer object) {
// try {
// boolean isNuevo = false;
// Usuario aeronave = iUsuarioRepository.FindByKey(object.Key);
// if (aeronave == null)
// isNuevo = true;
// aeronave = iUsuarioFactory.Create(object.Usuario, object.Password ,
// object.ti);

// for (var item : object.getAsientos()) {
// aeronave.agregarAsiento(item.key, item.keyAeronave, item.numero, item.clase,
// 200.00, 0);
// }
// if (isNuevo) {
// iAeronaveRepository.Create(aeronave);
// } else {
// iAeronaveRepository.Update(aeronave);
// }
// iUnitOfWork.commit();
// } catch (Exception e1) {
// e1.printStackTrace();
// }
// }

// }