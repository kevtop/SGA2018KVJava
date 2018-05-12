package edu.sga.core.service;

import java.util.List;

import edu.sga.core.model.Salon;

public interface SalonService {

	public void saveSalon(Salon elemento);
	public void deleteSalonById(Long codigoSalon);
	public void updateSalon(Salon elemento);
	public List<Salon> findAllSalon ();
	public Salon findById(Long codigoSalon);
}
