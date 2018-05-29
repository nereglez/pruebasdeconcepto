package pruebas.de.concepto.persistence.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Maestro {

	@Id
	@SequenceGenerator(name = "MaestroIdGenerator", sequenceName = "MaestroSeq")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "MaestroIdGenerator")
	private long id;

	private String nombre;

	private TipoMaestro tipoMaestro;

	private boolean esCampoCheck;

	@OneToOne(optional = true, fetch = FetchType.LAZY)
	@MapsId("subcategoria")
	private Maestro subCategoria;

	private String descripcion;

	private Date fechaCreacion;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TipoMaestro getTipoMaestro() {
		return tipoMaestro;
	}

	public void setTipoMaestro(TipoMaestro tipoMaestro) {
		this.tipoMaestro = tipoMaestro;
	}

	public boolean isEsCampoCheck() {
		return esCampoCheck;
	}

	public void setEsCampoCheck(boolean esCampoCheck) {
		this.esCampoCheck = esCampoCheck;
	}

	public Maestro getSubCategoria() {
		return subCategoria;
	}

	public void setSubCategoria(Maestro subCategoria) {
		this.subCategoria = subCategoria;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

}
