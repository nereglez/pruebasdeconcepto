package pruebas.de.concepto.persistence.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Usuario {

	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Usuario(String nombre, Sexo sexo, String email, Date fechaRegistro, String login) {
		super();
		this.nombre = nombre;
		this.sexo = sexo;
		this.email = email;
		this.fechaRegistro = fechaRegistro;
		this.login = login;
	}

	@Id
	@SequenceGenerator(name = "UsuarioIdGenerator", sequenceName = "UsuarioSeq")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "UsuarioIdGenerator")
	private long id;

	private String nombre;

	private String apellidos;

	private Date fechaNacimiento;

	private Sexo sexo;

	private String email;

	@OneToOne
	private Provincia provincia;

	private Date fechaRegistro;

	@Column(unique = true)
	private String login;

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

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

}
