package edu.sga.core.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="profesor")
public class Profesor implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="codigo_profesor")
	private Long codigoProfesor;
	@Column(name="apellidos")
	private String apellidos;
	@Column(name="nombres")
	private String nombres;
	@Column(name="fecha_nacimiento")
	private Date fechaNacimiento;
	@Column(name="numero_cursos")
	private Long numeroCursos;
	//de uno a muchos se debe crear un set para que devuelva varios objetos
	@OneToMany(mappedBy="profesor",fetch=FetchType.EAGER)
	private Set<Clase> clase;
	@OneToMany(mappedBy="profesor",fetch=FetchType.EAGER)
	private Set<ProfesoresCursos> profesoresCursos;
	//de uno a muchos se referencian los campos y se crea un campo del tipo de objeto que regresara
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="codigo_puesto",referencedColumnName="codigo_puesto",updatable=false,insertable=false,nullable=false)
	private Puesto puesto;
	//no se debe crear el constructor con el campo mapeado de relacion
	public Profesor(Long codigoProfesor, String apellidos, String nombres, Date fechaNacimiento, Long numeroCursos) {
		super();
		this.codigoProfesor = codigoProfesor;
		this.apellidos = apellidos;
		this.nombres = nombres;
		this.fechaNacimiento = fechaNacimiento;
		this.numeroCursos = numeroCursos;
	}
	public Profesor() {
		super();
	}
	public Long getCodigoProfesor() {
		return codigoProfesor;
	}
	public void setCodigoProfesor(Long codigoProfesor) {
		this.codigoProfesor = codigoProfesor;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public Long getNumeroCursos() {
		return numeroCursos;
	}
	public void setNumeroCursos(Long numeroCursos) {
		this.numeroCursos = numeroCursos;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellidos == null) ? 0 : apellidos.hashCode());
		result = prime * result + ((codigoProfesor == null) ? 0 : codigoProfesor.hashCode());
		result = prime * result + ((fechaNacimiento == null) ? 0 : fechaNacimiento.hashCode());
		result = prime * result + ((nombres == null) ? 0 : nombres.hashCode());
		result = prime * result + ((numeroCursos == null) ? 0 : numeroCursos.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profesor other = (Profesor) obj;
		if (apellidos == null) {
			if (other.apellidos != null)
				return false;
		} else if (!apellidos.equals(other.apellidos))
			return false;
		if (codigoProfesor == null) {
			if (other.codigoProfesor != null)
				return false;
		} else if (!codigoProfesor.equals(other.codigoProfesor))
			return false;
		if (fechaNacimiento == null) {
			if (other.fechaNacimiento != null)
				return false;
		} else if (!fechaNacimiento.equals(other.fechaNacimiento))
			return false;
		if (nombres == null) {
			if (other.nombres != null)
				return false;
		} else if (!nombres.equals(other.nombres))
			return false;
		if (numeroCursos == null) {
			if (other.numeroCursos != null)
				return false;
		} else if (!numeroCursos.equals(other.numeroCursos))
			return false;
		return true;
	}
	
}
