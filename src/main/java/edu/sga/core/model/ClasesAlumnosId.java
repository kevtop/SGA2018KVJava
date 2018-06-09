package edu.sga.core.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ClasesAlumnosId implements Serializable {

	//aqui se implementan los campos de la base de datos que hacen relacion
	@Column(name="codigo_alumno",nullable=false,updatable=false,insertable=true)
	private Long codigoAlumno;
	@Column(name="codigo_clase",nullable=false,updatable=false,insertable=true)
	private Long codigoClase;
	public ClasesAlumnosId(Long codigoAlumno, Long codigoClase) {
		super();
		this.codigoAlumno = codigoAlumno;
		this.codigoClase = codigoClase;
	}
	public ClasesAlumnosId() {
		super();
	}
	public Long getCodigoAlumno() {
		return codigoAlumno;
	}
	public void setCodigoAlumno(Long codigoAlumno) {
		this.codigoAlumno = codigoAlumno;
	}
	public Long getCodigoClase() {
		return codigoClase;
	}
	public void setCodigoClase(Long codigoClase) {
		this.codigoClase = codigoClase;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoAlumno == null) ? 0 : codigoAlumno.hashCode());
		result = prime * result + ((codigoClase == null) ? 0 : codigoClase.hashCode());
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
		ClasesAlumnosId other = (ClasesAlumnosId) obj;
		if (codigoAlumno == null) {
			if (other.codigoAlumno != null)
				return false;
		} else if (!codigoAlumno.equals(other.codigoAlumno))
			return false;
		if (codigoClase == null) {
			if (other.codigoClase != null)
				return false;
		} else if (!codigoClase.equals(other.codigoClase))
			return false;
		return true;
	}
	
}
