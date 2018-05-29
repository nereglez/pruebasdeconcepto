package pruebas.de.concepto.api.services.impl;

import org.springframework.stereotype.Service;

@Service(value = "myDefaultMethodServiceImpl")
public class MyDefaultMethodServiceImpl extends GenericDefaultMethodServiceImpl {

	@Override
	public String generateMessageLowercase() {
		String message = "This is a message";
		return transformString(message);
	}
	
	@Override
	public String generateMessageUppercase() {
		String message = "This is a message";
		return super.transformString(message);
	}
	
	/**
	 * <p>
	 * Returns message in lowercase.
	 * </p>
	 * 
	 * @param message
	 */
	public String transformString(String message) {
		return message.toLowerCase();
	}
}
