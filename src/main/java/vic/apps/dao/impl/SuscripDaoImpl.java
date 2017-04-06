package vic.apps.dao.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vic.apps.dao.SuscripDao;
import vic.apps.model.Acceso;
import vic.apps.model.Suscrip;

@Repository
@Transactional
public class SuscripDaoImpl implements SuscripDao {

	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(Suscrip suscrip) {
		session.getCurrentSession().save(suscrip);
	}

	@Override
	public void edit(Suscrip suscrip) {
		session.getCurrentSession().update(suscrip);
	}

	@Override
	public void delete(int suscripId) {
		session.getCurrentSession().delete(getSuscrip(suscripId));
	}

	
	@Override
	public Suscrip getSuscrip(int suscripId) {
		/*
		Session ses = session.getCurrentSession();
		Suscrip sus = (Suscrip)ses.get(Suscrip.class, new Integer(suscripId));
		Query qry = ses.createQuery("from accesos where id_sus=?");
		qry.setInteger(0, sus.getId_sus());
		List<Acceso> lst = qry.list();
		if (lst != null){
			Set<Acceso> accs = new HashSet<Acceso>(lst);
			sus.setAccesos(accs);
		}
		
		return sus;
		*/
		return (Suscrip)session.getCurrentSession().get(Suscrip.class, new Integer(suscripId));
	}

	@Override
	public List getAllSuscrip() {
		return session.getCurrentSession().createQuery("from vic.apps.model.suscripciones").list();
	}

	public SessionFactory getSessionFacRef(){
		return this.session;
	}

	@Override
	public Suscrip filterByIdEmp(int nidemp) {
		Suscrip s = null;
		String sql = "Select e From suscripciones e Inner Join e.accesos Where e.id_emp=?";
		Query qry = session.getCurrentSession().createQuery(sql);
		qry.setInteger(0, nidemp);
		try{
			s = (Suscrip)qry.list().get(0);
		}catch(Exception ex){
			ex.printStackTrace();
			s = null;
		}
		return s;
	}
}
