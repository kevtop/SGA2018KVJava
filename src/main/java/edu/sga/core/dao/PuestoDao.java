package edu.sga.core.dao;

import java.util.List;

import edu.sga.core.model.Puesto;

public interface PuestoDao {

	public void savePuesto(Puesto elemento);
	public void deletePuestoById(Long codigoPuesto);
	public void updatePuesto(Puesto elemento);
	public List<Puesto> findAllPuesto ();
	public Puesto findById(Long codigoPuesto);
}
