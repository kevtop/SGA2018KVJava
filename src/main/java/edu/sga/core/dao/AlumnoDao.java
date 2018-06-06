package edu.sga.core.dao;

import java.util.List;

import edu.sga.core.model.Alumno;

public interface AlumnoDao {

	public void saveAlumno(Alumno elemento);
	public void updateAlumno(Alumno elemento);
	public void deleteAlumnoById(Long codigoAlumno);
	public List<Alumno> findAllAlumnos();
	public Alumno findById(Long codigoAlumno);
	public List<Alumno> findByNombre(String nombre);
	
}
