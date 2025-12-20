package net.ipn.tutorias.service;

import java.util.List;

import net.ipn.tutorias.dto.UsuarioDTO;
import net.ipn.tutorias.model.CUsuario;

public interface IUsuarioService {
	
	List<UsuarioDTO> obtenerPorClase(Integer clase);
	CUsuario obtenerPorCorreo(String correo);
	void guardar(CUsuario usuario);
	
}
