package Model.Usuarios;

import java.util.UUID;

import core.AggregateRoot;

public class Usuario extends AggregateRoot<UUID> {

	public UUID keyUsuario;
	public String usuario;
	public String password;
	public String tipo;
	public String estado;

	public Usuario(String usuario, String password, String tipo, String estado) {
		this.keyUsuario = UUID.randomUUID();
		this.usuario = usuario;
		this.password = password;
		this.tipo = tipo;
		this.estado = estado;
	}

	// TODO sharekernel actualizar add usuario
	// public void eventCreado() {
	// addDomainEvent(new Usuario(usuario, password, tipo, estado));
	// }

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
