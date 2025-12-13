package net.ipn.tutorias.dto;

import java.util.Date;

public class ClaseDTO {
	private Integer id;
	private String titulo;
	private String descripcion;
	private String usuario;
	private Date fecha;
	
	
	public ClaseDTO(Integer id, String titulo, String descripcion, String usuario, Date fecha) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.usuario = usuario;
		this.fecha = fecha;
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
}
