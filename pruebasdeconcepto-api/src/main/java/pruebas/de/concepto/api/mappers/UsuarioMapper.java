package pruebas.de.concepto.api.mappers;

import org.mapstruct.Mapper;

import pruebas.de.concepto.api.dto.UsuarioDto;
import pruebas.de.concepto.persistence.entities.Usuario;

@Mapper(componentModel="spring")
public interface UsuarioMapper {
	
	UsuarioDto UsuarioToUsuarioDto(Usuario usuario);
	
	Usuario UsuarioDtoToUsuario(UsuarioDto usuario);


}
