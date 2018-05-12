package edu.sga.core.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sga.core.dao.AlumnoDao;
import edu.sga.core.model.Alumno;

@Service("AlumnoService")
@Transactional
public class AlumnoServiceImpl implements AlumnoService {

	@Autowired
	private AlumnoDao alumnoServiceDao;
	
	@Override
	public void saveAlumno(Alumno elemento) {
		alumnoServiceDao.saveAlumno(elemento);
		
	}

	@Override
	public void updateAlumno(Alumno elemento) {
		alumnoServiceDao.updateAlumno(elemento);
		
	}

	@Override
	public void deleteAlumnoById(Long codigoAlumno) {
		alumnoServiceDao.deleteAlumnoById(codigoAlumno);
		
	}

	@Override
	public List<Alumno> findAllAlumnos() {
		// TODO Auto-generated method stub
		return alumnoServiceDao.findAllAlumnos();
	}

	@Override
	public Alumno findById(Long codigoAlumno) {
		// TODO Auto-generated method stub
		return alumnoServiceDao.findById(codigoAlumno);
	}

	@Override
	public Alumno findByNombre(String nombre) {
		// TODO Auto-generated method stub
		return alumnoServiceDao.findByNombre(nombre);
	}

	
}
