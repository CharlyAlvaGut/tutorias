package net.ipn.tutorias.dto;

public class UsuarioDTO {
	private Integer id;
	private String nombre;
	private String correo;
	
	public UsuarioDTO() {
		super();
	}
	
	public UsuarioDTO(Integer id, String nombre, String correo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.correo = correo;
	}

	public UsuarioDTO(String nombre, String correo) {
		super();
		this.nombre = nombre;
		this.correo = correo;
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
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
}
