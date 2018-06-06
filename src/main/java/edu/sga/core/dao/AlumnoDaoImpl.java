package edu.sga.core.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import edu.sga.core.model.Alumno;

@Repository
@Transactional
public class AlumnoDaoImpl extends AbstractSession implements AlumnoDao {

	@Override
	public void saveAlumno(Alumno elemento) {
		getSession().persist(elemento);
		
	}

	@Override
	public void updateAlumno(Alumno elemento) {
		getSession().update(elemento);
		
	}

	@Override
	public void deleteAlumnoById(Long codigoAlumno) {
		Alumno alumno = findById(codigoAlumno);
		if(alumno != null) {
			getSession().delete(alumno);
		}
		
	}

	@Override
	public List<Alumno> findAllAlumnos() {
		
		return getSession().createQuery("from Alumno").list();
	}

	@Override
	public Alumno findById(Long codigoAlumno) {
		
		return getSession().get(Alumno.class, codigoAlumno);
	}

	@Override
	public List<Alumno> findByNombre(String nombre) {
		
		return (List<Alumno>)getSession().createQuery("from Alumno where nombres like :nombres").setParameter("nombres", nombre).list();
	}
	
	

}
