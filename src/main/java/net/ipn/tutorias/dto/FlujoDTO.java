package net.ipn.tutorias.dto;

import java.util.Date;

public class FlujoDTO {
	private Integer id;
	private String nombre;
	private String estatus;
	private Date fecha;
	public FlujoDTO(Integer id, String nombre, String estatus, Date fecha) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.estatus = estatus;
		this.fecha = fecha;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
}
