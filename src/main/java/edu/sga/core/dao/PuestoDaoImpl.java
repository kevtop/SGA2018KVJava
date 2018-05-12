package edu.sga.core.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import edu.sga.core.model.Puesto;

@Repository
@Transactional
public class PuestoDaoImpl extends AbstractSession implements PuestoDao {

	@Override
	public void savePuesto(Puesto elemento) {
		getSession().persist(elemento);
		
	}

	@Override
	public void deletePuestoById(Long codigoPuesto) {
		Puesto puesto = findById(codigoPuesto);
		if(puesto != null) {
			getSession().delete(puesto);
		}
	}

	@Override
	public void updatePuesto(Puesto elemento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Puesto> findAllPuesto() {
		// TODO Auto-generated method stub
		return getSession().createQuery("from Puesto").list();
	}

	@Override
	public Puesto findById(Long codigoPuesto) {
		// TODO Auto-generated method stub
		return getSession().get(Puesto.class, codigoPuesto);
	}

	
}
