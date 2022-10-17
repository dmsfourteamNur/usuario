package Repositories;

import java.util.List;
import java.util.UUID;

import Model.Usuarios.Usuario;
import core.IRepository;

public interface IUsuarioRepository extends IRepository<Usuario, UUID> {
	public List<Usuario> GetAll() throws Exception;

	public Usuario Delete(Usuario vuelo) throws Exception;

	public Usuario Update(Usuario vuelo) throws Exception;

}