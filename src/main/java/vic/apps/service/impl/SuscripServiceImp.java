package vic.apps.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vic.apps.dao.SuscripDao;
import vic.apps.dao.impl.SuscripDaoImpl;
import vic.apps.model.Acceso;
import vic.apps.model.Suscrip;
import vic.apps.service.SuscripService;

@Service
public class SuscripServiceImp implements SuscripService {

	private boolean withsefa;
	
	@Autowired
	private SuscripDao susDao;
	@Autowired
	private SessionFactory sf;
	
	@Transactional
	public void add(Suscrip suscrip) {
		susDao.add(suscrip);
	}

	@Transactional
	public void addBatch(Suscrip suscrip, Acceso acceso){
		//System.out.println(suscrip.toString());
		//System.out.println(acceso.toString());
		
		Session ss = sf.getCurrentSession();
		//try{
			//ss.beginTransaction();
			ss.save(suscrip);
			
			acceso.setSuscrip(suscrip);
			suscrip.getAccesos().add(acceso);
			ss.save(acceso);
			
			//ss.getTransaction().commit();
		//}finally{
			//ss.close();
		//}
		
	}
	
	@Transactional
	public void edit(Suscrip suscrip) {
		susDao.edit(suscrip);
	}

	@Transactional
	public void delete(int suscripId) {
		susDao.delete(suscripId);
	}

	@Transactional
	public Suscrip getSuscrip(int suscripId) {
		return susDao.getSuscrip(suscripId);
	}

	@Transactional
	public List getAllSuscrip() {
		return susDao.getAllSuscrip();
	}

	@Transactional
	public Suscrip filterByIdEmp(int nidemp) {
		return susDao.filterByIdEmp(nidemp);
	}

	public void withSF(boolean withsessionfac) {
		this.withsefa = withsessionfac;
		
	}

	@Transactional
	public Suscrip nsfFilterByIdEmp(int nidemp) {
		//Session ss = sf.getCurrentSession();
		//ss.getTransaction().begin();
		Suscrip sus = susDao.filterByIdEmp(nidemp);
		//ss.getTransaction().commit();
		//ss.close();
		return sus;
	}

}
