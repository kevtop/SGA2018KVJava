package edu.sga.core.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="profesores_cursos")
public class ProfesoresCursos implements Serializable {
	
	//primero la llave maestra compuesta
	@EmbeddedId
	private ProfesoresCursosId profesoresCursosId;
	//luego los campos propios de la entidad
	@Column(name="tutor")
	private String tutor;
	
	private Clase clase;
	//luego las relaciones entre tablas
	//basandome en los campos de la tabla y agregando las propiedades como estan en la tabla updatable,nullable,insertable
	//haciendo la relacion con la etiqueta joincolumn y poniendo los campos de la relacion creando un objeto del tipo que va regresar el ManyToOne
	@ManyToOne
	@JoinColumn(name="codigo_curso",referencedColumnName="codigo_curso",nullable=false,insertable=true,updatable=false)
	private Curso curso;
	@ManyToOne
	@JoinColumn(name="codigo_profesor",referencedColumnName="codigo_profesor",nullable=false,insertable=true,updatable=false)
	private Profesor profesor;
	public ProfesoresCursos(ProfesoresCursosId profesoresCursosId, String tutor) {
		super();
		this.profesoresCursosId = profesoresCursosId;
		this.tutor = tutor;
	}
	public ProfesoresCursos() {
		super();
	}
	public ProfesoresCursosId getProfesoresCursosId() {
		return profesoresCursosId;
	}
	public void setProfesoresCursosId(ProfesoresCursosId profesoresCursosId) {
		this.profesoresCursosId = profesoresCursosId;
	}
	public String getTutor() {
		return tutor;
	}
	public void setTutor(String tutor) {
		this.tutor = tutor;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((profesoresCursosId == null) ? 0 : profesoresCursosId.hashCode());
		result = prime * result + ((tutor == null) ? 0 : tutor.hashCode());
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
		ProfesoresCursos other = (ProfesoresCursos) obj;
		if (profesoresCursosId == null) {
			if (other.profesoresCursosId != null)
				return false;
		} else if (!profesoresCursosId.equals(other.profesoresCursosId))
			return false;
		if (tutor == null) {
			if (other.tutor != null)
				return false;
		} else if (!tutor.equals(other.tutor))
			return false;
		return true;
	}
	

}
