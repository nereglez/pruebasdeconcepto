package pruebas.de.concepto.api.services;

import pruebas.de.concepto.api.dto.UsuarioDto;

public interface UsuarioService {

	UsuarioDto findByLogin(String login);
}
