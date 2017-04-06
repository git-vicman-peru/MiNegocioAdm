package vic.apps.model.fix;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="vic.apps.model.fix.suscripciones")
@JsonIgnoreProperties(ignoreUnknown=true)
public class SuscripX implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_sus;
	
	@Column
	private int id_emp;

	@Column
	private String vouch_nro;
	@Column
	private Date vouch_fecha;
	@Column
	private String vouch_bank;
	@Column
	private float vouch_monto;
	@Column
	private String tipo;
	@Column
	private Boolean activo;
	@Column
	private String obs;
	
	public SuscripX(){
		this.activo = false;
	}

	public int getId_sus() {
		return id_sus;
	}

	public void setId_sus(int id_sus) {
		this.id_sus = id_sus;
	}

	public int getId_emp() {
		return id_emp;
	}

	public void setId_emp(int id_emp) {
		this.id_emp = id_emp;
	}

	public String getVouch_nro() {
		return vouch_nro;
	}

	public void setVouch_nro(String vouch_nro) {
		this.vouch_nro = vouch_nro;
	}

	public Date getVouch_fecha() {
		return vouch_fecha;
	}

	public void setVouch_fecha(Date vouch_fecha) {
		this.vouch_fecha = vouch_fecha;
	}

	public String getVouch_bank() {
		return vouch_bank;
	}

	public void setVouch_bank(String vouch_bank) {
		this.vouch_bank = vouch_bank;
	}

	public float getVouch_monto() {
		return vouch_monto;
	}

	public void setVouch_monto(float vouch_monto) {
		this.vouch_monto = vouch_monto;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	@Override
	public String toString() {
		return "SuscripX [id_sus=" + id_sus + ", id_emp=" + id_emp + ", vouch_nro=" + vouch_nro
				+ ", vouch_fecha=" + vouch_fecha + ", vouch_bank=" + vouch_bank + ", vouch_monto=" + vouch_monto
				+ ", tipo=" + tipo + ", activo=" + activo + ", obs=" + obs + "]";
	}
	
}
