package Factories;

import Model.Usuarios.Usuario;

public class UsuarioFactory implements IUsuarioFactory {

	public UsuarioFactory() {
	}

	@Override
	public Usuario Create(String usuario, String password, String tipo, String estado) {
		return new Usuario(usuario, password, tipo, estado);
	}

}