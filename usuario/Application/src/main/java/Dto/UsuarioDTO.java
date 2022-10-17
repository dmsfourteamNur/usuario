package Dto;

import java.util.UUID;

public class UsuarioDTO {

	public UUID keyUsuario;
	public String usuario;
	public String password;
	public String tipo;
	public String estado;

	public UUID getKeyUsuario() {
		return keyUsuario;
	}

	public void setKeyUsuario(UUID keyUsuario) {
		this.keyUsuario = keyUsuario;
	}

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