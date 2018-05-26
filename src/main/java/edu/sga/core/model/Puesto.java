package edu.sga.core.model;

import java.io.Serializable;
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
@Table(name="puesto")
public class Puesto implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigo_puesto")
	private Long codigoPuesto;
	@Column(name="descripcion")
	private String descripcion;
	@OneToMany(mappedBy="puesto",fetch=FetchType.EAGER)
	private Set<Profesor> profesor;
	public Puesto(Long codigoPuesto, String descripcion) {
		super();
		this.codigoPuesto = codigoPuesto;
		this.descripcion = descripcion;
	}
	public Puesto() {
		super();
	}
	public Long getCodigoPuesto() {
		return codigoPuesto;
	}
	public void setCodigoPuesto(Long codigoPuesto) {
		this.codigoPuesto = codigoPuesto;
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
		result = prime * result + ((codigoPuesto == null) ? 0 : codigoPuesto.hashCode());
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
		Puesto other = (Puesto) obj;
		if (codigoPuesto == null) {
			if (other.codigoPuesto != null)
				return false;
		} else if (!codigoPuesto.equals(other.codigoPuesto))
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		return true;
	}
	

	
}
