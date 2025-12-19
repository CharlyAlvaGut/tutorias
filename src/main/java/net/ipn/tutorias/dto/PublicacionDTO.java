package net.ipn.tutorias.dto;

import java.util.Date;

public class PublicacionDTO {
	private Integer id;
	private String descripcion;
	private String usuario;
	private Date fecha;
	private Integer[] documentos;
	
	
	public PublicacionDTO(Integer id, String descripcion, String usuario, Date fecha, Integer[] documentos) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.usuario = usuario;
		this.fecha = fecha;
		this.documentos = documentos;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Integer[] getDocumentos() {
		return documentos;
	}
	public void setDocumentos(Integer[] documentos) {
		this.documentos = documentos;
	}
}
