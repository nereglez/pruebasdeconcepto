package pruebas.de.concepto.api.services.impl;

import org.springframework.stereotype.Service;

import pruebas.de.concepto.api.services.DefaultMethodInterfaceService;

@Service
public class GenericDefaultMethodServiceImpl implements DefaultMethodInterfaceService {

	@Override
	public String generateMessageLowercase() {
		return this.generateMessageLowercase();
	}
	
	@Override
	public String generateMessageUppercase() {
		return this.generateMessageUppercase();
	}

}
