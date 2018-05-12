package edu.sga.core.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sga.core.dao.ProfesorDao;
import edu.sga.core.model.Profesor;

@Service("ProfesorService")
@Transactional
public class ProfesorServiceImpl implements ProfesorService {

	@Autowired
	private ProfesorDao profesorDao;
	
	
	@Override
	public void saveProfesor(Profesor elemento) {
		profesorDao.saveProfesor(elemento);
		
	}

	@Override
	public void deleteProfesorById(Long codigoProfesor) {
		profesorDao.deleteProfesorById(codigoProfesor);
		
	}

	@Override
	public void updateProfesor(Profesor elemento) {
		profesorDao.updateProfesor(elemento);
		
	}

	@Override
	public List<Profesor> findAllProfesor() {
		// TODO Auto-generated method stub
		return profesorDao.findAllProfesor();
	}

	@Override
	public Profesor findById(Long codigoProfesor) {
		// TODO Auto-generated method stub
		return profesorDao.findById(codigoProfesor);
	}

}
