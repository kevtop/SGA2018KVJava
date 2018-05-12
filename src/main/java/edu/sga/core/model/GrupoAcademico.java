package edu.sga.core.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="grupoacademico")
public class GrupoAcademico implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="codigo_grupoacademico")
	private Long codigoGrupoAcademico;
	@Column(name="descripcion")
	private String descripcion;
	@OneToMany(mappedBy="grupoacademico",fetch=FetchType.EAGER)
	private Set<Clase> clase = new HashSet<Clase>();
	public GrupoAcademico() {
		super();
	}
	public GrupoAcademico(Long codigoGrupoAcademico, String descripcion) {
		super();
		this.codigoGrupoAcademico = codigoGrupoAcademico;
		this.descripcion = descripcion;
	}
	public Long getCodigoGrupoAcademico() {
		return codigoGrupoAcademico;
	}
	public void setCodigoGrupoAcademico(Long codigoGrupoAcademico) {
		this.codigoGrupoAcademico = codigoGrupoAcademico;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoGrupoAcademico == null) ? 0 : codigoGrupoAcademico.hashCode());
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
		GrupoAcademico other = (GrupoAcademico) obj;
		if (codigoGrupoAcademico == null) {
			if (other.codigoGrupoAcademico != null)
				return false;
		} else if (!codigoGrupoAcademico.equals(other.codigoGrupoAcademico))
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		return true;
	}
	
	
}
