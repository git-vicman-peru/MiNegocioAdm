package vic.apps.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vic.apps.dao.AccesoDao;
import vic.apps.model.Acceso;

@Repository
public class AccesoDaoImpl implements AccesoDao {

	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(Acceso acceso) {
		session.getCurrentSession().save(acceso);
	}

	@Override
	public void edit(Acceso acceso) {
		session.getCurrentSession().update(acceso);
	}

	@Override
	public void delete(int accesoId) {
		session.getCurrentSession().delete(getAcceso(accesoId));
	}

	@Override
	public Acceso getAcceso(int accesoId) {
		return (Acceso)session.getCurrentSession().get(Acceso.class, accesoId);
	}

	@Override
	public List getAllAcceso() {
		return session.getCurrentSession().createQuery("from accesos").list();
	}

}
