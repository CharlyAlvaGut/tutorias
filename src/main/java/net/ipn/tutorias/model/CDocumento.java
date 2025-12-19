package net.ipn.tutorias.model;

import java.util.Arrays;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name="documentos")
public class CDocumento {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Integer id;
	private Integer idPublicacion;
	private String nombre;
	@Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] documento;
    
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdPublicacion() {
		return idPublicacion;
	}
	public void setIdPublicacion(Integer idPublicacion) {
		this.idPublicacion = idPublicacion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public byte[] getDocumento() {
		return documento;
	}
	public void setDocumento(byte[] documento) {
		this.documento = documento;
	}
	
	@Override
	public String toString() {
		return "CDocumento [id=" + id + ", idPublicacion=" + idPublicacion + ", nombre=" + nombre + ", documento="
				+ Arrays.toString(documento) + "]";
	}
}
