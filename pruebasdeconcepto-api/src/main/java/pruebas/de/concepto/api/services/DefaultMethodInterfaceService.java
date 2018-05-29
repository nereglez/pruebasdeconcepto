package pruebas.de.concepto.api.services;

public interface DefaultMethodInterfaceService {

	public String generateMessageLowercase() ;
	
	public String generateMessageUppercase() ;
	
	/**
	 * <p>
	 * Returns message in uppercase.
	 * </p>
	 * 
	 * @param message
	 */
	default String transformString(String message) {
		return message.toUpperCase();
	}
}
