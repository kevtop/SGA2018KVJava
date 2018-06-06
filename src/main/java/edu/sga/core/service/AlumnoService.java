package edu.sga.core.service;

import java.util.List;

import edu.sga.core.model.Alumno;

public interface AlumnoService {

	public void saveAlumno(Alumno elemento);
	public void updateAlumno(Alumno elemento);
	public void deleteAlumnoById(Long codigoAlumno);
	public List<Alumno> findAllAlumnos();
	public Alumno findById(Long codigoAlumno);
	public List<Alumno> findByNombre(String nombre);
}
