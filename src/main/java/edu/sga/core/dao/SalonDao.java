package edu.sga.core.dao;

import java.util.List;

import edu.sga.core.model.Salon;

public interface SalonDao {

	public void saveSalon(Salon elemento);
	public void deleteSalonById(Long codigoSalon);
	public void updateSalon(Salon elemento);
	public List<Salon> findAllSalon ();
	public Salon findById(Long codigoSalon);
}
