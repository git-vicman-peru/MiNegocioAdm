package vic.apps.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

import vic.apps.model.fix.SuscripX;

@Repository
@Transactional
public class SuscripDaoX {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	public SuscripX addSuscrip(SuscripX sus){
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(sus);
		return sus;
	}

	public SuscripX getSuscrip(int susId){
		Session session = this.sessionFactory.getCurrentSession();
		SuscripX sus = (SuscripX)session.load(SuscripX.class, new Integer(susId));
		return sus;
	}
}
