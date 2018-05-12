package edu.sga.core.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sga.core.dao.GrupoAcademicoDao;
import edu.sga.core.model.GrupoAcademico;

@Service("GrupoAcademicoService")
@Transactional
public class GrupoAcademicoServiceImpl implements GrupoAcademicoService {

	@Autowired
	private GrupoAcademicoDao grupoAcademicoDao;
	
	
	@Override
	public void saveGrupoAcademico(GrupoAcademico elemento) {
		grupoAcademicoDao.saveGrupoAcademico(elemento);
		
	}

	@Override
	public void deleteGrupoAcademicoById(Long codigoGrupoAcademico) {
		grupoAcademicoDao.deleteGrupoAcademicoById(codigoGrupoAcademico);
		
	}

	@Override
	public void updateGrupoAcademico(GrupoAcademico elemento) {
		grupoAcademicoDao.updateGrupoAcademico(elemento);
		
	}

	@Override
	public List<GrupoAcademico> findAllGrupoAcademico() {
		
		return grupoAcademicoDao.findAllGrupoAcademico();
	}

	@Override
	public GrupoAcademico findById(Long codigoGrupoAcademico) {
		
		return grupoAcademicoDao.findById(codigoGrupoAcademico);
	}

	@Override
	public GrupoAcademico findByDescription(String descripcion) {
		
		return grupoAcademicoDao.findByDescription(descripcion);
	}

	
	
}
