package edu.sga.core.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="clases_alumnos")
public class ClasesAlumnos implements Serializable {

	@EmbeddedId
	private ClasesAlumnosId clasesAlumnoId;
	@Column(name="fecha_asignacion")
	private Date fechaAsignacion;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="codigo_alumno",referencedColumnName="codigo_alumno",updatable=false,nullable=false,insertable=true)
	private Alumno alumno;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="codigo_clase",referencedColumnName="codigo_clase",updatable=false,nullable=false,insertable=true)
	private Clase clase;
	public ClasesAlumnos(ClasesAlumnosId clasesAlumnoId, Date fechaAsignacion) {
		super();
		this.clasesAlumnoId = clasesAlumnoId;
		this.fechaAsignacion = fechaAsignacion;
	}
	public ClasesAlumnos() {
		super();
	}
	public ClasesAlumnosId getClasesAlumnoId() {
		return clasesAlumnoId;
	}
	public void setClasesAlumnoId(ClasesAlumnosId clasesAlumnoId) {
		this.clasesAlumnoId = clasesAlumnoId;
	}
	public Date getFechaAsignacion() {
		return fechaAsignacion;
	}
	public void setFechaAsignacion(Date fechaAsignacion) {
		this.fechaAsignacion = fechaAsignacion;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clasesAlumnoId == null) ? 0 : clasesAlumnoId.hashCode());
		result = prime * result + ((fechaAsignacion == null) ? 0 : fechaAsignacion.hashCode());
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
		ClasesAlumnos other = (ClasesAlumnos) obj;
		if (clasesAlumnoId == null) {
			if (other.clasesAlumnoId != null)
				return false;
		} else if (!clasesAlumnoId.equals(other.clasesAlumnoId))
			return false;
		if (fechaAsignacion == null) {
			if (other.fechaAsignacion != null)
				return false;
		} else if (!fechaAsignacion.equals(other.fechaAsignacion))
			return false;
		return true;
	}
	
	
}
