package edu.sga.core.service;

import java.util.List;

import edu.sga.core.model.Curso;

public interface CursoService {

	public void saveCurso(Curso elemento);
	public void updateCurso(Curso elemento);
	public void deleteCursoById(Long codigoCurso);
	public List<Curso> findAllCurso();
	public Curso findById(Long codigoCurso);
	public Curso findByDescripcion(String descripcion);
}
