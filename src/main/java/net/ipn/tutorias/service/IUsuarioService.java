package net.ipn.tutorias.service;

import net.ipn.tutorias.model.CUsuario;

public interface IUsuarioService {
	
	CUsuario obtenerPorCorreo(String correo);
	void guardar(CUsuario usuario);
	
}
