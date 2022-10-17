package Factories;

import Model.Usuarios.Usuario;

public interface IUsuarioFactory {
	public Usuario Create(String usuario, String password, String tipo, String estado);
}
