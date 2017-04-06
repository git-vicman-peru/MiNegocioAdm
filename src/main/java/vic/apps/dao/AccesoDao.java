package vic.apps.dao;

import java.util.List;

import vic.apps.model.Acceso;

public interface AccesoDao {
	public void add(Acceso acceso);
	public void edit(Acceso acceso);
	public void delete(int accesoId);
	public Acceso getAcceso(int accesoId);
	public List getAllAcceso();
}
