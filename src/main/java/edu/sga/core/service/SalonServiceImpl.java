package edu.sga.core.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import edu.sga.core.dao.SalonDao;
import edu.sga.core.model.Salon;

@Service("SalonService")
@Transactional

public class SalonServiceImpl implements SalonService{

	private SalonDao salonDao;
	
	@Override
	public void saveSalon(Salon elemento) {
		salonDao.saveSalon(elemento);
		
	}

	@Override
	public void deleteSalonById(Long codigoSalon) {
		salonDao.deleteSalonById(codigoSalon);
		
	}

	@Override
	public void updateSalon(Salon elemento) {
		salonDao.updateSalon(elemento);
		
	}

	@Override
	public List<Salon> findAllSalon() {
		// TODO Auto-generated method stub
		return salonDao.findAllSalon();
	}

	@Override
	public Salon findById(Long codigoSalon) {
		// TODO Auto-generated method stub
		return salonDao.findById(codigoSalon);
	}

	
}
