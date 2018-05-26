package edu.sga.core.model;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.Set;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="clase")
public class Clase implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="codigo_clase")
	private Long codigoClase;
	@Column(name="nombre")
	private String nombre;
	@Column(name="hora_inicio")
	@Temporal(value = TemporalType.TIME)
	private Date horaInicio;
	@Column(name="hora_fin")
	@Temporal(value = TemporalType.TIME)
	private Date horaFin;
	@Column(name="fecha_inicio")
	private Date fechaInicio;
	@Column(name="fecha_fin")
	private Date fechaFin;
	@Column(name="codigo_profesor",nullable=false,updatable=false,insertable=false)
	private Long codigoProfesor;
	@Column(name="codigo_curso",nullable=false,updatable=false,insertable=false)
	private Long codigoCurso;
	@ManyToOne
	@JoinColumns({@JoinColumn(name="codigo_profesor",referencedColumnName="codigo_profesor",insertable=false,updatable=false,nullable=false),@JoinColumn(name="codigo_curso",referencedColumnName="codigo_curso",nullable=false,insertable=false,updatable=false)})
	private ProfesoresCursos profesoresCursos;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="codigo_salon",referencedColumnName="codigo_salon",nullable=false,updatable=false,insertable=false)
	private Salon salon;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="codigo_grupoacademico",referencedColumnName="codigo_grupoacademico",nullable=false,updatable=false,insertable=false)
	private GrupoAcademico grupoacademico;
	@OneToMany(mappedBy="clase",fetch = FetchType.EAGER)
	private Set<ClasesAlumnos> clasesAlumnos;
	public Clase(Long codigoClase, String nombre, Date horaInicio, Date horaFin, Date fechaInicio, Date fechaFin,
			Salon codigoSalon, GrupoAcademico grupoAcademico, Profesor profesor, Curso curso) {
		super();
		this.codigoClase = codigoClase;
		this.nombre = nombre;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.salon = codigoSalon;
		this.grupoacademico = grupoAcademico;
	}
	public Clase() {
		super();
	}
	public Long getCodigoClase() {
		return codigoClase;
	}
	public void setCodigoClase(Long codigoClase) {
		this.codigoClase = codigoClase;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}
	public Date getHoraFin() {
		return horaFin;
	}
	public void setHoraFin(Date horaFin) {
		this.horaFin = horaFin;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public Salon getCodigoSalon() {
		return salon;
	}
	public void setCodigoSalon(Salon codigoSalon) {
		this.salon = codigoSalon;
	}
	public GrupoAcademico getGrupoAcademico() {
		return grupoacademico;
	}
	public void setGrupoAcademico(GrupoAcademico grupoAcademico) {
		this.grupoacademico = grupoAcademico;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoClase == null) ? 0 : codigoClase.hashCode());
		result = prime * result + ((salon == null) ? 0 : salon.hashCode());
		result = prime * result + ((fechaFin == null) ? 0 : fechaFin.hashCode());
		result = prime * result + ((fechaInicio == null) ? 0 : fechaInicio.hashCode());
		result = prime * result + ((grupoacademico == null) ? 0 : grupoacademico.hashCode());
		result = prime * result + ((horaFin == null) ? 0 : horaFin.hashCode());
		result = prime * result + ((horaInicio == null) ? 0 : horaInicio.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		Clase other = (Clase) obj;
		if (codigoClase == null) {
			if (other.codigoClase != null)
				return false;
		} else if (!codigoClase.equals(other.codigoClase))
			return false;
		if (salon == null) {
			if (other.salon != null)
				return false;
		} else if (!salon.equals(other.salon))
			return false;
		if (fechaFin == null) {
			if (other.fechaFin != null)
				return false;
		} else if (!fechaFin.equals(other.fechaFin))
			return false;
		if (fechaInicio == null) {
			if (other.fechaInicio != null)
				return false;
		} else if (!fechaInicio.equals(other.fechaInicio))
			return false;
		if (grupoacademico == null) {
			if (other.grupoacademico != null)
				return false;
		} else if (!grupoacademico.equals(other.grupoacademico))
			return false;
		if (horaFin == null) {
			if (other.horaFin != null)
				return false;
		} else if (!horaFin.equals(other.horaFin))
			return false;
		if (horaInicio == null) {
			if (other.horaInicio != null)
				return false;
		} else if (!horaInicio.equals(other.horaInicio))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return false;
	}
	
	
}
