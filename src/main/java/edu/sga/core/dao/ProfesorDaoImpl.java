package edu.sga.core.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import edu.sga.core.model.Profesor;

@Repository
@Transactional
public class ProfesorDaoImpl extends AbstractSession implements ProfesorDao {

	@Override
	public void saveProfesor(Profesor elemento) {
		getSession().persist(elemento);
		
	}

	@Override
	public void deleteProfesorById(Long codigoProfesor) {
		Profesor profesor = findById(codigoProfesor);
		if(profesor != null) {
			getSession().delete(profesor);
		}
		
	}

	@Override
	public void updateProfesor(Profesor elemento) {
		getSession().update(elemento);
		
	}

	@Override
	public List<Profesor> findAllProfesor() {
		// TODO Auto-generated method stub
		return getSession().createQuery("from Profesor").list();
	}

	@Override
	public Profesor findById(Long codigoProfesor) {
		// TODO Auto-generated method stub
		return getSession().get(Profesor.class, codigoProfesor);
	}

	
}
