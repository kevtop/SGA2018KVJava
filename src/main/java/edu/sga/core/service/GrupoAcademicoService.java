package edu.sga.core.service;

import java.util.List;

import edu.sga.core.model.GrupoAcademico;

public interface GrupoAcademicoService {

	public void saveGrupoAcademico(GrupoAcademico elemento);
	public void deleteGrupoAcademicoById(Long codigoGrupoAcademico);
	public void updateGrupoAcademico(GrupoAcademico elemento);
	public List<GrupoAcademico> findAllGrupoAcademico();
	public GrupoAcademico findById(Long codigoGrupoAcademico);
	public GrupoAcademico findByDescription(String descripcion);
}
