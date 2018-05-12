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
@Table(name="salon")

public class Salon implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="codigo_salon")
	private Long codigoSalon;
	@Column(name="salon")
	private String salon;
	@OneToMany(mappedBy="salon",fetch = FetchType.EAGER)
	private Set<Clase> clase;
	public Salon() {
		super();
	}
	public Salon(Long codigoSalon, String salon) {
		super();
		this.codigoSalon = codigoSalon;
		this.salon = salon;
	}
	public Long getCodigoSalon() {
		return codigoSalon;
	}
	public void setCodigoSalon(Long codigoSalon) {
		this.codigoSalon = codigoSalon;
	}
	public String getSalon() {
		return salon;
	}
	public void setSalon(String salon) {
		this.salon = salon;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoSalon == null) ? 0 : codigoSalon.hashCode());
		result = prime * result + ((salon == null) ? 0 : salon.hashCode());
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
		Salon other = (Salon) obj;
		if (codigoSalon == null) {
			if (other.codigoSalon != null)
				return false;
		} else if (!codigoSalon.equals(other.codigoSalon))
			return false;
		if (salon == null) {
			if (other.salon != null)
				return false;
		} else if (!salon.equals(other.salon))
			return false;
		return true;
	}
	
	
}