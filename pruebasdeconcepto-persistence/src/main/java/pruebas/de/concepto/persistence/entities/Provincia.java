package pruebas.de.concepto.persistence.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Provincia {

	@Id
	@SequenceGenerator(name = "ProvinciaIdGenerator", sequenceName = "ProvinciaSeq")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "ProvinciaIdGenerator")
	private long id;

	@OneToOne
	private Pais pais;

	private String nombre;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
