package vic.apps.service;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vic.apps.dao.SuscripDaoX;
import vic.apps.model.fix.SuscripX;

@Service//("suscripXService")
public class SuscripXService {

	@Autowired
	private SuscripDaoX susxDao;
	
	@Transactional
	public void addSuscrip(SuscripX sus){
		susxDao.addSuscrip(sus);
	}
	
	@Transactional
	public SuscripX getSuscrip(int susId){
		return susxDao.getSuscrip(susId);
	}
}
