package edu.sga.core.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import edu.sga.core.model.Salon;

@Repository
@Transactional
public class SalonDaoImpl extends AbstractSession implements SalonDao {

	@Override
	public void saveSalon(Salon elemento) {
		getSession().persist(elemento);
		
	}

	@Override
	public void deleteSalonById(Long codigoSalon) {
		Salon salon = findById(codigoSalon);
		if(salon != null) {
			getSession().delete(salon);
		}
	}

	@Override
	public void updateSalon(Salon elemento) {
		getSession().update(elemento);
		
	}

	@Override
	public List<Salon> findAllSalon() {
		// TODO Auto-generated method stub
		return getSession().createQuery("from Salon").list();
	}

	@Override
	public Salon findById(Long codigoSalon) {
		// TODO Auto-generated method stub
		return getSession().get(Salon.class, codigoSalon);
	}

}
