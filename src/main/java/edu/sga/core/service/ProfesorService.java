package edu.sga.core.service;

import java.util.List;

import edu.sga.core.model.Profesor;

public interface ProfesorService {

	public void saveProfesor(Profesor elemento);
	public void deleteProfesorById(Long codigoProfesor);
	public void updateProfesor(Profesor elemento);
	public List<Profesor> findAllProfesor();
	public Profesor findById(Long codigoProfesor);
}
