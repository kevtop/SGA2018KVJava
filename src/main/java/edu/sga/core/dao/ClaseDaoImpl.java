package edu.sga.core.dao;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import edu.sga.core.model.Clase;

@Repository
@Transactional
public class ClaseDaoImpl extends AbstractSession implements ClaseDao {

	@Override
	public void saveClase(Clase elemento) {
		getSession().persist(elemento);
		
	}

	@Override
	public void updateClase(Clase elemento) {
		getSession().update(elemento);
		
	}

	@Override
	public void deleteByIdClase(Long codigoClase) {
		Clase clase = findById(codigoClase);
		if(clase!=null) {
			getSession().delete(clase);
		}
		
	}

	@Override
	public List<Clase> findAllClase() {
		
		return getSession().createQuery("from Clase").list();
	}

	@Override
	public Clase findById(Long codigoClase) {
		// TODO Auto-generated method stub
		return getSession().get(Clase.class, codigoClase);
	}

	@Override
	public Clase findByNombre(String nombre) {
		// TODO Auto-generated method stub
		return (Clase)getSession().createQuery("from Clase where nombre = :nombre").setParameter(nombre, "nombre").list();
	}

	
	

	
}
