package vic.apps.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name="accesos")
public class Acceso {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_acc;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_sus", nullable=false)
	@JsonIgnoreProperties(value={"accesos"}, allowSetters=true)
	private Suscrip suscrip;
	
	public Suscrip getSuscrip() {
		return suscrip;
	}

	public void setSuscrip(Suscrip suscrip) {
		this.suscrip = suscrip;
	}

	@Column
	private String usuario;
	@Column
	private String clave;
	@Column
	private Boolean vigente;
	
	public Acceso(){
		this.vigente = false;
	}

	public int getId_acc() {
		return id_acc;
	}

	public void setId_acc(int id_acc) {
		this.id_acc = id_acc;
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

	public Boolean getVigente() {
		return vigente;
	}

	public void setVigente(Boolean vigente) {
		this.vigente = vigente;
	}

	@Override
	public String toString() {
		return "Acceso [id_acc=" + id_acc + ", suscrip=" + suscrip + ", usuario=" + usuario + ", clave=" + clave
				+ ", vigente=" + vigente + "]";
	}
	
}
