package edu.sga.core.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sga.core.dao.ClaseDao;
import edu.sga.core.model.Clase;

@Service("ClaseService")
@Transactional
public class ClaseServiceImpl implements ClaseService{

	@Autowired
	private ClaseDao claseDao;
	
	@Override
	public void saveClase(Clase elemento) {
		claseDao.saveClase(elemento);
		
	}

	@Override
	public void updateClase(Clase elemento) {
		claseDao.updateClase(elemento);
		
	}

	@Override
	public void deleteByIdClase(Long codigoClase) {
		claseDao.deleteByIdClase(codigoClase);
		
	}

	@Override
	public List<Clase> findAllClase() {
		// TODO Auto-generated method stub
		return claseDao.findAllClase();
	}

	@Override
	public Clase findById(Long codigoClase) {
		// TODO Auto-generated method stub
		return claseDao.findById(codigoClase);
	}

	@Override
	public Clase findByNombre(String nombre) {
		// TODO Auto-generated method stub
		return claseDao.findByNombre(nombre);
	}

	
}
