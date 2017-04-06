package vic.apps.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vic.apps.dao.impl.ConfigDaoImpl;
import vic.apps.model.Config;
import vic.apps.service.ConfigService;

@Service
public class ConfigServiceImpl implements ConfigService {

	@Autowired
	private ConfigDaoImpl cfgServ;
	
	@Transactional
	public void add(Config config) {
		cfgServ.add(config);
	}

	@Transactional
	public void edit(Config config) {
		cfgServ.edit(config);
	}

	@Transactional
	public void delete(int configId) {
		cfgServ.delete(configId);
	}

	@Transactional
	public Config getConfig(int configId) {
		return cfgServ.getConfig(configId);
	}

	@Transactional
	public List getAllConfig() {
		return cfgServ.getAllConfig();
	}

}
