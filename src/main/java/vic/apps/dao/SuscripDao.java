package vic.apps.dao;

import java.util.List;

import vic.apps.model.Suscrip;

public interface SuscripDao {
	public void add(Suscrip suscrip);
	public void edit(Suscrip suscrip);
	public void delete(int suscripId);
	public Suscrip getSuscrip(int suscripId);
	public Suscrip filterByIdEmp(int nidemp);
	public List getAllSuscrip();
}
