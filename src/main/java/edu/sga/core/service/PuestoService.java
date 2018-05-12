package edu.sga.core.service;

import java.util.List;

import edu.sga.core.model.Puesto;

public interface PuestoService {

	public void savePuesto(Puesto elemento);
	public void deletePuestoById(Long codigoPuesto);
	public void updatePuesto(Puesto elemento);
	public List<Puesto> findAllPuesto ();
	public Puesto findById(Long codigoPuesto);
}
