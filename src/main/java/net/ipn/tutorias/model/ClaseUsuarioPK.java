package net.ipn.tutorias.model;

import java.util.Objects;

public class ClaseUsuarioPK {
	private Integer idClase;
	private Integer idUsuario;
	
	public ClaseUsuarioPK() {
		super();
	}
	public ClaseUsuarioPK(Integer idClase, Integer idUsuario) {
		super();
		this.idClase = idClase;
		this.idUsuario = idUsuario;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(idClase, idUsuario);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClaseUsuarioPK other = (ClaseUsuarioPK) obj;
		return Objects.equals(idClase, other.idClase) && Objects.equals(idUsuario, other.idUsuario);
	}
	
	
	public Integer getIdClase() {
		return idClase;
	}
	public void setIdClase(Integer idClase) {
		this.idClase = idClase;
	}
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	
}
