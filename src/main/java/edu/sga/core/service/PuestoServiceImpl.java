package edu.sga.core.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sga.core.dao.PuestoDao;
import edu.sga.core.model.Puesto;

@Service("PuestoService")
@Transactional
public class PuestoServiceImpl implements PuestoService{

	@Autowired
	private PuestoDao puestoDao;
	
	@Override
	public void savePuesto(Puesto elemento) {
		puestoDao.savePuesto(elemento);
		
	}

	@Override
	public void deletePuestoById(Long codigoPuesto) {
		puestoDao.deletePuestoById(codigoPuesto);
		
	}

	@Override
	public void updatePuesto(Puesto elemento) {
		puestoDao.updatePuesto(elemento);
		
	}

	@Override
	public List<Puesto> findAllPuesto() {
		// TODO Auto-generated method stub
		return puestoDao.findAllPuesto();
	}

	@Override
	public Puesto findById(Long codigoPuesto) {
		// TODO Auto-generated method stub
		return puestoDao.findById(codigoPuesto);
	}

}
