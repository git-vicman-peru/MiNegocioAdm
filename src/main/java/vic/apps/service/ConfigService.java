package vic.apps.service;

import java.util.List;

import vic.apps.model.Config;

public interface ConfigService {
	public void add(Config config);
	public void edit(Config config);
	public void delete(int configId);
	public Config getConfig(int configId);
	public List getAllConfig();
}
