package edu.sga.core.dao;

import java.util.List;

import edu.sga.core.model.Carrera;

public interface CarreraDao {

	public void saveCarrera(Carrera elemento);
	public void deleteCarreraById(Long codigoCarrera);
	public void updateCarrera(Carrera elemento);
	public List<Carrera> findAllCarreras();
	public Carrera findById(Long codigoCarrera);
	public Carrera findByDescription(String descripcion);
	
}
