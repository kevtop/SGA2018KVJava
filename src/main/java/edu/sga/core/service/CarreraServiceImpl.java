package edu.sga.core.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sga.core.dao.CarreraDao;
import edu.sga.core.model.Carrera;

@Service("CarreraService")
@Transactional
public class CarreraServiceImpl implements CarreraService {

	@Autowired
	private CarreraDao carreraServiceDao;
	
	@Override
	public void saveCarrera(Carrera elemento) {
		carreraServiceDao.saveCarrera(elemento);
		
	}

	@Override
	public void deleteCarreraById(Long codigoCarrera) {
		carreraServiceDao.deleteCarreraById(codigoCarrera);
		
	}

	@Override
	public void updateCarrera(Carrera elemento) {
		carreraServiceDao.updateCarrera(elemento);
		
	}

	@Override
	public List<Carrera> findAllCarreras() {
		
		return carreraServiceDao.findAllCarreras();
	}

	@Override
	public Carrera findById(Long codigoCarrera) {
		return carreraServiceDao.findById(codigoCarrera);
	}

	@Override
	public Carrera findByDescription(String descripcion) {
		return carreraServiceDao.findByDescription(descripcion);
	}

	
}
