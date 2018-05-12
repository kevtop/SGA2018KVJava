package edu.sga.core.dao;

import java.util.List;

import edu.sga.core.model.Curso;

public interface CursoDao {
	
	public void saveCurso(Curso elemento);
	public void updateCurso(Curso elemento);
	public void deleteCursoById(Long codigoCurso);
	public List<Curso> findAllCurso();
	public Curso findById(Long codigoCurso);
	public Curso findByDescripcion(String descripcion);

}
