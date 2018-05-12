package edu.sga.core.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import edu.sga.core.model.GrupoAcademico;

@Repository
@Transactional
public class GrupoAcademicoDaoImpl extends AbstractSession implements GrupoAcademicoDao {

	@Override
	public void saveGrupoAcademico(GrupoAcademico elemento) {
		getSession().persist(elemento);
		
	}

	@Override
	public void deleteGrupoAcademicoById(Long codigoGrupoAcademico) {
		GrupoAcademico grupo = findById(codigoGrupoAcademico);
		if(grupo != null) {
			getSession().delete(grupo);
		}
		
	}

	@Override
	public void updateGrupoAcademico(GrupoAcademico elemento) {
		getSession().update(elemento);
		
	}

	@Override
	public List<GrupoAcademico> findAllGrupoAcademico() {
		
		return getSession().createQuery("from GrupoAcademico").list();
	}

	@Override
	public GrupoAcademico findById(Long codigoGrupoAcademico) {
		
		return getSession().get(GrupoAcademico.class, codigoGrupoAcademico);
	}

	@Override
	public GrupoAcademico findByDescription(String descripcion) {
		
		return (GrupoAcademico)getSession().createQuery("from GrupoAcademico where descripcion = :descripcion").setParameter("descripcion", descripcion).uniqueResult();
	}

	
}
