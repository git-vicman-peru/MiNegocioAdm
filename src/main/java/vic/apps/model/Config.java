package vic.apps.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="config_ap")
public class Config {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_cfg;
	@Column
	private String categoria;
	@Column
	private String grupo;
	@Column
	private String subgrupo;
	@Column
	private String nombre;
	@Column
	private String descripcion;
	@Column
	private String valor;
	@Column
	private int tagint;
	@Column
	private boolean tagbool;
	@Column
	private float tagdec;
	
	public Config(){
		
	}

	public Config(String categoria, String nombre, String descripcion, String valor, int tagint) {
		this.categoria = categoria;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.valor = valor;
		this.tagint = tagint;
	}

	public int getId_cfg() {
		return id_cfg;
	}

	public void setId_cfg(int id_cfg) {
		this.id_cfg = id_cfg;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public String getSubgrupo() {
		return subgrupo;
	}

	public void setSubgrupo(String subgrupo) {
		this.subgrupo = subgrupo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Config [id_cfg=" + id_cfg + ", categoria=" + categoria + ", grupo=" + grupo + ", subgrupo=" + subgrupo
				+ ", nombre=" + nombre + ", descripcion=" + descripcion + ", valor=" + valor + ", tagint=" + tagint
				+ ", tagbool=" + tagbool + ", tagdec=" + tagdec + "]";
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public int getTagint() {
		return tagint;
	}

	public void setTagint(int tagint) {
		this.tagint = tagint;
	}

	public boolean isTagbool() {
		return tagbool;
	}

	public void setTagbool(boolean tagbool) {
		this.tagbool = tagbool;
	}

	public float getTagdec() {
		return tagdec;
	}

	public void setTagdec(float tagdec) {
		this.tagdec = tagdec;
	}
	
	
}
