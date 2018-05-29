package pruebas.de.concepto.persistence.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pruebas.de.concepto.persistence.entities.Usuario;

public interface UsuarioRepositorio extends CrudRepository<Usuario, Long> {

	Usuario findByLogin(String login);

}
