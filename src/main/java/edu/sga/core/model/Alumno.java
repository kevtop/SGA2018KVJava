package edu.sga.core.model;

import java.util.Date;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//se utiliza para pegarlo a una entidad
@Entity
//se utiliza para identificar la tabla a la que se pegara
@Table(name="alumno")
//se utiliza serializable para hacer todos los modelos serializados
public class Alumno implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo_alumno")  
	private Long codigoAlumno;
	@Column(name = "apellidos")
	private String apellidos;
	@Column(name = "nombres")
	private String nombres;
	@Column(name = "fecha_nacimiento")
	private Date fechaNacimiento;
	@Column(name = "carne")
	private String carne;
	//haciendo la relacion de tablas de muchos a uno
	//fetch eager sirve para cargar de una vez todos los elementos
	//fetch lazy sirve para cargar solo los elementos asociados cuando se requieren
	@ManyToOne(fetch = FetchType.EAGER)
	//con la etiqueta joincolumn se utilizan los campos a nivel de tablas
	@JoinColumn(name="codigo_carrera",referencedColumnName="codigo_carrera",updatable=false,insertable=true,nullable=false)
	private Carrera carrera;
	public Alumno() {
		
	}
	public Alumno(Long codigoAlumno, String apellidos, String nombres, Date fechaNacimiento, String carne,
			Carrera carrera) {
		super();
		this.codigoAlumno = codigoAlumno;
		this.apellidos = apellidos;
		this.nombres = nombres;
		this.fechaNacimiento = fechaNacimiento;
		this.carne = carne;
		this.carrera = carrera;
	}
	public Long getCodigoAlumno() {
		return codigoAlumno;
	}
	public void setCodigoAlumno(Long codigoAlumno) {
		this.codigoAlumno = codigoAlumno;
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
	public String getCarne() {
		return carne;
	}
	public void setCarne(String carne) {
		this.carne = carne;
	}
	public Carrera getCarrera() {
		return carrera;
	}
	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellidos == null) ? 0 : apellidos.hashCode());
		result = prime * result + ((carne == null) ? 0 : carne.hashCode());
		result = prime * result + ((carrera == null) ? 0 : carrera.hashCode());
		result = prime * result + ((codigoAlumno == null) ? 0 : codigoAlumno.hashCode());
		result = prime * result + ((fechaNacimiento == null) ? 0 : fechaNacimiento.hashCode());
		result = prime * result + ((nombres == null) ? 0 : nombres.hashCode());
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
		Alumno other = (Alumno) obj;
		if (apellidos == null) {
			if (other.apellidos != null)
				return false;
		} else if (!apellidos.equals(other.apellidos))
			return false;
		if (carne == null) {
			if (other.carne != null)
				return false;
		} else if (!carne.equals(other.carne))
			return false;
		if (carrera == null) {
			if (other.carrera != null)
				return false;
		} else if (!carrera.equals(other.carrera))
			return false;
		if (codigoAlumno == null) {
			if (other.codigoAlumno != null)
				return false;
		} else if (!codigoAlumno.equals(other.codigoAlumno))
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
		return true;
	}
	
	
	
	
	
	
	

}
