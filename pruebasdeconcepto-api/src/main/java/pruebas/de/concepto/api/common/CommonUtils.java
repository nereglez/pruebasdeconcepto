package pruebas.de.concepto.api.common;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CommonUtils {
	private static final Logger log = LoggerFactory.getLogger(CommonUtils.class);

	/** Mapper de Dto a Json. */
	private static ObjectMapper mapper = new ObjectMapper();

	/**
	 * *** HEADERS *****.
	 *
	 * @return the cors
	 */

	/**
	 * @return the cors
	 */
	public static HttpHeaders getCors() {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
		return responseHeaders;

	}

	/**
	 * map de cantidad de nuevos resultados desde la ultima busqueda.
	 *
	 * @param nuevos
	 *            the nuevos
	 * @param modified
	 *            the modified
	 * @param responseHeaders
	 *            the response headers
	 * @return String de respuesta
	 */
	public static String mapNewCount(int nuevos, int modified, HttpHeaders responseHeaders) {
		responseHeaders.set("Success", Integer.toString(nuevos));
		return "{\"NUEVOS\":\"".concat(Integer.toString(nuevos)).concat("\",\"MODIFICADOS\":\"")
				.concat(Integer.toString(modified)).concat("\"}");
	}

	/**
	 * map del id del ultimo error insertado.
	 *
	 * @param last
	 *            the last
	 * @param responseHeaders
	 *            the response headers
	 * @return String de respuesta
	 */
	public static String mapLastError(String last, HttpHeaders responseHeaders) {
		responseHeaders.set("Success", last);
		return "{\"ULTIMO\":\"".concat(last).concat("\"}");
	}

	/**
	 * Map json.
	 *
	 * @param results
	 *            resultados obtenidos
	 * @return mapped results
	 */
	public static String mapJson(List<?> results) {
		String result = "";
		try {
			result = mapper.writeValueAsString(results);
		} catch (JsonGenerationException e) {
			log.error(Constants.ERROR, e);
		} catch (JsonMappingException e) {
			log.error(Constants.ERROR, e);
		} catch (IOException e) {
			log.error(Constants.ERROR, e);
		}
		return result;
	}

	/**
	 * Map json.
	 *
	 * @param results
	 *            resultados obtenidos
	 * @return mapped results
	 */
	public static String mapJson(Object results) {
		String result = "";
		try {
			result = mapper.writeValueAsString(results);
		} catch (JsonGenerationException e) {
			log.error(Constants.ERROR, e);
		} catch (JsonMappingException e) {
			log.error(Constants.ERROR, e);
		} catch (IOException e) {
			log.error(Constants.ERROR, e);
		}
		return result;
	}

	/**
	 * Tiempo actual del sistema.
	 *
	 * @return tiempo actual
	 */
	public static long getTimeMillis() {
		return System.currentTimeMillis();
	}

}
