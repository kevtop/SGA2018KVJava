package edu.sga.core.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import edu.sga.core.model.Curso;

@Repository
@Transactional
public class CursoDaoImpl extends AbstractSession implements CursoDao {

	@Override
	public void saveCurso(Curso elemento) {
		getSession().persist(elemento);
		
	}

	@Override
	public void updateCurso(Curso elemento) {
		getSession().update(elemento);
		
	}

	@Override
	public void deleteCursoById(Long codigoCurso) {
		Curso curso = findById(codigoCurso);
		if(curso != null) {
			getSession().delete(curso);
		}
		
	}

	@Override
	public List<Curso> findAllCurso() {
		// TODO Auto-generated method stub
		return getSession().createQuery("from Curso").list();
	}

	@Override
	public Curso findById(Long codigoCurso) {
		// TODO Auto-generated method stub
		return getSession().get(Curso.class, codigoCurso);
	}

	@Override
	public Curso findByDescripcion(String descripcion) {
		// TODO Auto-generated method stub
		return (Curso)getSession().createQuery("from Curso where descripcion = :descripcion").setParameter("descripcion", descripcion).uniqueResult();
	}

	
}
