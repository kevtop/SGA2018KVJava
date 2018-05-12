package edu.sga.core.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ProfesoresCursosId implements Serializable {

	@Column(name="codigo_curso",updatable=false,nullable=false,insertable=false)
	private Long codigoCurso;
	@Column(name="codigo_profesor",updatable=false,nullable=false,insertable=false)
	private Long codigoProfesor;
	public ProfesoresCursosId() {
		super();
	}
	public ProfesoresCursosId(Long codigoCurso, Long codigoProfesor) {
		super();
		this.codigoCurso = codigoCurso;
		this.codigoProfesor = codigoProfesor;
	}
	public Long getCodigoCurso() {
		return codigoCurso;
	}
	public void setCodigoCurso(Long codigoCurso) {
		this.codigoCurso = codigoCurso;
	}
	public Long getCodigoProfesor() {
		return codigoProfesor;
	}
	public void setCodigoProfesor(Long codigoProfesor) {
		this.codigoProfesor = codigoProfesor;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoCurso == null) ? 0 : codigoCurso.hashCode());
		result = prime * result + ((codigoProfesor == null) ? 0 : codigoProfesor.hashCode());
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
		ProfesoresCursosId other = (ProfesoresCursosId) obj;
		if (codigoCurso == null) {
			if (other.codigoCurso != null)
				return false;
		} else if (!codigoCurso.equals(other.codigoCurso))
			return false;
		if (codigoProfesor == null) {
			if (other.codigoProfesor != null)
				return false;
		} else if (!codigoProfesor.equals(other.codigoProfesor))
			return false;
		return true;
	}
	
}
