package vic.apps.service;

import java.util.List;

import vic.apps.model.Acceso;
import vic.apps.model.Suscrip;

public interface SuscripService {
	public void withSF(boolean withsessionfac);
	public void add(Suscrip suscrip);
	public void addBatch(Suscrip suscrip, Acceso acceso);
	public void edit(Suscrip suscrip);
	public void delete(int suscripId);
	public Suscrip getSuscrip(int suscripId);
	public Suscrip filterByIdEmp(int nidemp);
	public Suscrip nsfFilterByIdEmp(int nidemp);
	public List getAllSuscrip();
}
