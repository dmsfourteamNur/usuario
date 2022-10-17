package Repository;

import java.util.List;
import java.util.UUID;

import Context.IWriteDbContext;
import Fourteam.db.DbSet;
import Model.Usuarios.Usuario;
import Repositories.IUsuarioRepository;

public class UsuarioRepository implements IUsuarioRepository {

	private DbSet<Usuario> _Usuario;

	public UsuarioRepository(IWriteDbContext database) {
		_Usuario = database.Usuario;
	}

	@Override
	public List<Usuario> GetAll() throws Exception {
		return _Usuario.All();
	}

	@Override
	public Usuario FindByKey(UUID key) throws Exception {
		return _Usuario.Single(obj -> obj.key.equals(key));
	}

	@Override
	public void Create(Usuario objVuelo) throws Exception {
		_Usuario.Add(objVuelo);
	}

	@Override
	public Usuario Update(Usuario objVuelo) throws Exception {
		_Usuario.Update(objVuelo, (it -> it.key.equals(objVuelo.key)));
		return objVuelo;
	}

	@Override
	public Usuario Delete(Usuario objVuelo) throws Exception {
		_Usuario.Delete((it -> it.key.equals(objVuelo.key)));
		return objVuelo;
	}

}