package net.ipn.tutorias.service;

public interface IClaseUsuarioService {
	boolean inscribir(Integer idClase, Integer idUsuario);
	boolean eliminar(Integer idClase, Integer idUsuario);
}
