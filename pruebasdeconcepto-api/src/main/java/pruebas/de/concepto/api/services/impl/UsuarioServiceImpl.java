package pruebas.de.concepto.api.services.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pruebas.de.concepto.persistence.repositories.UsuarioRepositorio;

import pruebas.de.concepto.api.dto.UsuarioDto;
import pruebas.de.concepto.api.mappers.UsuarioMapper;
import pruebas.de.concepto.api.services.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	@Autowired
	private UsuarioMapper usuarioMapper;

	@Override
	@Transactional
	public UsuarioDto findByLogin(String login) {
		return usuarioMapper.UsuarioToUsuarioDto(usuarioRepositorio.findByLogin(login));
	}
	
	

}
