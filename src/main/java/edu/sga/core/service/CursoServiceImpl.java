package edu.sga.core.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sga.core.dao.CursoDao;
import edu.sga.core.model.Curso;

@Service("CursoService")
@Transactional
public class CursoServiceImpl implements CursoService {

	@Autowired
	private CursoDao cursoDao;

	@Override
	public void saveCurso(Curso elemento) {
		cursoDao.saveCurso(elemento);
		
	}

	@Override
	public void updateCurso(Curso elemento) {
		cursoDao.updateCurso(elemento);
		
	}

	@Override
	public void deleteCursoById(Long codigoCurso) {
		cursoDao.deleteCursoById(codigoCurso);
		
	}

	@Override
	public List<Curso> findAllCurso() {
		// TODO Auto-generated method stub
		return cursoDao.findAllCurso();
	}

	@Override
	public Curso findById(Long codigoCurso) {
		// TODO Auto-generated method stub
		return cursoDao.findById(codigoCurso);
	}

	@Override
	public Curso findByDescripcion(String descripcion) {
		// TODO Auto-generated method stub
		return cursoDao.findByDescripcion(descripcion);
	}
	
	
	
}
