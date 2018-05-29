package pruebas.de.concepto.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import pruebas.de.concepto.ApiConstants;
import pruebas.de.concepto.api.common.CommonUtils;
import pruebas.de.concepto.api.common.LogConstants;
import pruebas.de.concepto.api.dto.UsuarioDto;
import pruebas.de.concepto.api.services.UsuarioService;
import pruebas.de.concepto.dtos.ObjetoDTO;

@RestController
@RequestMapping("/api/1.0/ejemplo")
public class EjemploController {
	
	@Autowired
	private UsuarioService usuarioService;

	@ApiOperation(value = "Envío de un POST", httpMethod = "POST", notes = ApiConstants.EJEMPLO_POST)
	@ApiResponses(value = { @ApiResponse(code = 200, message = ApiConstants.CODE_200),
			@ApiResponse(code = 400, message = ApiConstants.CODE_400) })
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody ResponseEntity<String> pruebaListaLongs(
			final @ApiParam(value = ApiConstants.QUERY_PARAM, required = true) @RequestHeader String query,
			final @ApiParam(value = "Cambio a realizar add/modify", required = true, example = "{“parametros“:[{“campo”:”TaxRate”,”valor”:”21.00”,”valorNuevo”:”10.00”}]}") @RequestBody String bodyData) {
		HttpHeaders responseHeaders = CommonUtils.getCors();

		// map a Json los resultados de la busqueda
		String jsonResponse = CommonUtils.mapJson("");

		responseHeaders.add(LogConstants.SUCCESS_HEADER, "Modificada Información de ejemplo.");

		return new ResponseEntity<String>(jsonResponse, responseHeaders, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json", path="/listaLongs")
	public @ResponseBody Object pruebaListaLongs(@RequestParam(value = "buleano", required = false) Boolean buleano,
			final @RequestBody List<Long> listaLongs) {

		HttpHeaders responseHeaders = CommonUtils.getCors();
		// map a Json los resultados de la busqueda
		String jsonResponse = CommonUtils.mapJson(listaLongs.get(0).longValue());

		responseHeaders.add(LogConstants.SUCCESS_HEADER, "Modificada Información de ejemplo.");
		return new ResponseEntity<String>(jsonResponse, responseHeaders, HttpStatus.OK);

	}
	
	@ApiOperation(value = "Obtener usuario por login. Ejemplo de GET", response = ObjetoDTO.class, responseContainer = "Object", httpMethod = "GET", notes = ApiConstants.EJEMPLO_GET)
	@ApiResponses(value = { @ApiResponse(code = 200, message = ApiConstants.CODE_200) })
	@RequestMapping(method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
	public @ResponseBody ResponseEntity<String> findUsuarioByLogin(@RequestParam String login) {
		HttpHeaders responseHeaders = CommonUtils.getCors();
		UsuarioDto usuario = usuarioService.findByLogin(login);
		// map a Json los resultados de la busqueda
		String jsonResponse = CommonUtils.mapJson(usuario);

		responseHeaders.add(LogConstants.SUCCESS_HEADER, "Recuperada Información de usuario.");

		return new ResponseEntity<String>(jsonResponse, responseHeaders, HttpStatus.OK);
	}

}
