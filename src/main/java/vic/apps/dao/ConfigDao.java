package vic.apps.dao;

import java.util.List;

import vic.apps.model.Config;

public interface ConfigDao {
	public void add(Config config);
	public void edit(Config config);
	public void delete(int configId);
	public Config getConfig(int configId);
	public List getAllConfig();
}
