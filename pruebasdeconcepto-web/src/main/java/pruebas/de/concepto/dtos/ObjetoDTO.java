package pruebas.de.concepto.dtos;

import java.io.IOException;
import java.util.Date;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjetoDTO {

	private String propiedad;

	private Date date;

	public String getPropiedad() {
		return propiedad;
	}

	public void setPropiedad(String propiedad) {
		this.propiedad = propiedad;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public static void main (String [] args) {
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "{ \"propiedad\" : \"Black\", \"date\" : \"2018-06-29T22:00:00.000Z\" }";
		try {
			ObjetoDTO car = objectMapper.readValue(json, ObjetoDTO.class);
			System.out.println(car.getDate());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

}
