package edu.sga.core.dao;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import edu.sga.core.model.Carrera;

@Repository
@Transactional
public class CarreraDaoImpl extends AbstractSession implements CarreraDao{

	
	
	@Override
	public Carrera findById(Long codigoCarrera) {
		return (Carrera)getSession().get(Carrera.class, codigoCarrera);
	}

	@Override
	public Carrera findByDescription(String descripcion) {
		// TODO Auto-generated method stub
		return (Carrera)getSession().createQuery("from Carrera where descripcion = :descripcion").
				setParameter("descripcion", descripcion).uniqueResult();
	}

	@Override
	public void saveCarrera(Carrera elemento) {
		getSession().persist(elemento);
		
	}

	@Override
	public void deleteCarreraById(Long codigoCarrera) {
		Carrera carrera = findById(codigoCarrera);
		if(carrera != null) {
			getSession().delete(carrera);
		}
	}

	@Override
	public void updateCarrera(Carrera elemento) {
		getSession().update(elemento);
		
	}

	@Override
	public List<Carrera> findAllCarreras() {
		
		return getSession().createQuery("from Carrera").list();
	}

	
}
