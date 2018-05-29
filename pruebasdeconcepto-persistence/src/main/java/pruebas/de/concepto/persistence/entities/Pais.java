package pruebas.de.concepto.persistence.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Pais {
	@Id
	@SequenceGenerator(name = "PaisIdGenerator", sequenceName = "PaisSeq")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "PaisIdGenerator")
	private long id;

	private String codigoISO;

	private String nombre;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCodigoISO() {
		return codigoISO;
	}

	public void setCodigoISO(String codigoISO) {
		this.codigoISO = codigoISO;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
