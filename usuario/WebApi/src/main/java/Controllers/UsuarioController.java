package Controllers;

import java.util.List;

import Dto.UsuarioDTO;
import Fourteam.http.Exception.HttpException;
import Fourteam.http.annotation.DeleteMapping;
import Fourteam.http.annotation.GetMapping;
import Fourteam.http.annotation.PathVariable;
import Fourteam.http.annotation.PostMapping;
import Fourteam.http.annotation.PutMapping;
import Fourteam.http.annotation.RequestBody;
import Fourteam.http.annotation.RequestMapping;
import Fourteam.http.annotation.RestController;
import Fourteam.mediator.Mediator;
import Fourteam.mediator.Response;
import Model.Usuarios.Usuario;
import UseCases.Command.Usuarios.Crear.CrearUsuarioCommand;
import UseCases.Command.Usuarios.Editar.EditarUsuarioCommand;
import UseCases.Command.Usuarios.Eliminar.EliminarUsuarioCommand;
import UseCases.Queries.Usuarios.GetAll.GetAllUsuarioQuery;
import UseCases.Queries.Usuarios.GetByKey.GetUsuarioByKeyQuery;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	private Mediator _mediator;

	public UsuarioController(Mediator mediator) {
		_mediator = mediator;
	}

	@GetMapping("/")
	public List<UsuarioDTO> getAll() throws HttpException {
		try {
			Response<List<UsuarioDTO>> lista = _mediator.send(new GetAllUsuarioQuery());
			return lista.data;
		} catch (Exception e) {
			e.printStackTrace();
			throw new HttpException(404, "Error " + e.getMessage());
		}
	}

	@PostMapping("/registro")
	public Usuario register(@RequestBody CrearUsuarioCommand vuelo)
			throws Exception {
		return (Usuario) _mediator.send(vuelo).data;
	}

	@GetMapping("/{key}")
	public Response<UsuarioDTO> getByKey(@PathVariable GetUsuarioByKeyQuery request)
			throws HttpException {
		try {
			return _mediator.send(request);
		} catch (Exception e) {
			throw new HttpException(404, e.getMessage());
		}
	}

	@PutMapping("/{key}")
	public UsuarioDTO edit(
			@RequestBody Usuario vuelo,
			@PathVariable EditarUsuarioCommand request) throws HttpException {
		request.usuarioDTO.setUsuario(vuelo.getUsuario());
		request.usuarioDTO.setPassword(vuelo.getPassword());
		request.usuarioDTO.setTipo(vuelo.getTipo());
		request.usuarioDTO.setEstado(vuelo.getEstado());
		try {
			return (UsuarioDTO) _mediator.send(request).data;
		} catch (Exception e) {
			throw (HttpException) e.getCause();
		}
	}

	@DeleteMapping("/{key}")
	public Response<UsuarioDTO> delete(@PathVariable EliminarUsuarioCommand request)
			throws HttpException {
		try {
			return _mediator.send(request);
		} catch (Exception e) {
			throw new HttpException(404, e.getMessage());
		}
	}
}