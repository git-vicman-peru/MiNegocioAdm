package vic.apps.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name="vic.apps.model.suscripciones")
public class Suscrip {

	//private static final long serialVersionUID = -7878298850931200561L;

	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_sus;
	
	@Column
	private int id_emp;
	
	@Column
	private String razonsocial;
	
	@OneToMany(targetEntity=Acceso.class, mappedBy="suscrip", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JsonIgnoreProperties(value={"suscrip"}, allowSetters=true)
	private Set<Acceso> accesos = new HashSet<Acceso>(0);
	
	public Set<Acceso> getAccesos() {
		return accesos;
	}

	public void setAccesos(Set<Acceso> accesos) {
		this.accesos = accesos;
	}

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
	
	@Column
	private String usuario;
	
	@Column
	private String clave;
	
	@Column
	private String pregunta;
	
	@Column
	private String respuesta;
	
	public Suscrip(){
		this.activo = false;
	}

	
	public String getRazonsocial() {
		return razonsocial;
	}

	public void setRazonsocial(String razonsocial) {
		this.razonsocial = razonsocial;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
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
		return "Suscrip [id_sus=" + id_sus + ", id_emp=" + id_emp + ", razonsocial=" + razonsocial + ", accesos="
				+ accesos + ", vouch_nro=" + vouch_nro + ", vouch_fecha=" + vouch_fecha + ", vouch_bank=" + vouch_bank
				+ ", vouch_monto=" + vouch_monto + ", tipo=" + tipo + ", activo=" + activo + ", obs=" + obs
				+ ", usuario=" + usuario + ", clave=" + clave + ", pregunta=" + pregunta + ", respuesta=" + respuesta
				+ "]";
	}

	public ErrorObj checkForErrors(){
		ErrorObj eo = new ErrorObj();
		eo.setFlg(false);
		/*
		if (this.id_emp < 1){
			eo.setFlg(true);
			eo.setFldName("id_emp");
			eo.setMsg("debe ser mayor que 1!");
			return eo;
		}*/
		if (eo.isStrNull(this.razonsocial)){
			eo.ready(true, "razonsocial", "no puede estar vacio.");
			return eo;
		}
		if (eo.isStrNull(this.vouch_nro)){
			eo.ready(true, "vouch_nro", "no puede estar vacio.");
			return eo;
		}
		if (this.vouch_fecha == null){
			eo.setFlg(true);
			eo.setFldName("vouch_fecha");
			eo.setMsg("La fecha no puede estar vacia!");
			return eo;
		}
		if (this.vouch_monto < 100){
			eo.setFlg(true);
			eo.setFldName("vouch_monto");
			eo.setMsg("El monto debe ser mayor que 100!");
			return eo;
		}
		return eo;
	}
	/*
	public String[] checkEmpties(){
		String[] a = {"id_emp","vouch_nro","vouch_fecha","vouch_monto","tipo","usuario","clave"};
		return a;
	}
	*/
}
