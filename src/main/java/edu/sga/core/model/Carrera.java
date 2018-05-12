package edu.sga.core.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "carrera")
public class Carrera implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="codigo_carrera")
	private Long codigoCarrera;
	@Column(name="descripcion")
	private String descripcion;
	@JsonIgnore
	@OneToMany(mappedBy="carrera")
	private Set<Alumno> alumno = new HashSet<Alumno>();
	public Carrera() {
		
	}
	public Carrera(Long codigoCarrera, String descripcion, Set<Alumno> alumno) {
		super();
		this.codigoCarrera = codigoCarrera;
		this.descripcion = descripcion;
		this.alumno = alumno;
	}
	public Long getCodigoCarrera() {
		return codigoCarrera;
	}
	public void setCodigoCarrera(Long codigoCarrera) {
		this.codigoCarrera = codigoCarrera;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Set<Alumno> getAlumno() {
		return alumno;
	}
	public void setAlumno(Set<Alumno> alumno) {
		this.alumno = alumno;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alumno == null) ? 0 : alumno.hashCode());
		result = prime * result + ((codigoCarrera == null) ? 0 : codigoCarrera.hashCode());
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
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
		Carrera other = (Carrera) obj;
		if (alumno == null) {
			if (other.alumno != null)
				return false;
		} else if (!alumno.equals(other.alumno))
			return false;
		if (codigoCarrera == null) {
			if (other.codigoCarrera != null)
				return false;
		} else if (!codigoCarrera.equals(other.codigoCarrera))
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		return true;
	}
	
}
