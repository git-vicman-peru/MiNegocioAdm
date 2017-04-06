package vic.apps.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vic.apps.dao.ConfigDao;
import vic.apps.model.Config;

@Repository
public class ConfigDaoImpl implements ConfigDao {

	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(Config config) {
		session.getCurrentSession().save(config);
	}

	@Override
	public void edit(Config config) {
		session.getCurrentSession().update(config);
	}

	@Override
	public void delete(int configId) {
		session.getCurrentSession().delete(getConfig(configId));
	}

	@Override
	public Config getConfig(int configId) {
		return (Config)session.getCurrentSession().get(Config.class, configId);
	}

	@Override
	public List getAllConfig() {
		return session.getCurrentSession().createQuery("from config_ap").list();
	}

}
