package Context;

import Fourteam.db.DbContext;
import Fourteam.db.DbSet;
import Fourteam.db.Exception.DataBaseException;
import Model.Usuarios.Usuario;

public abstract class IWriteDbContext extends DbContext {

	public IWriteDbContext(Class dbContextClass) throws DataBaseException {
		super(dbContextClass);
	}

	// name data base
	public DbSet<Usuario> Usuario;
}
