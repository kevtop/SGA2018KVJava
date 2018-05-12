package edu.sga.core.service;

import java.util.List;

import edu.sga.core.model.Clase;

public interface ClaseService {

	public void saveClase(Clase elemento);
	public void updateClase(Clase elemento);
	public void deleteByIdClase(Long codigoClase);
	public List<Clase> findAllClase();
	public Clase findById(Long codigoClase);
	public Clase findByNombre(String nombre);
}
