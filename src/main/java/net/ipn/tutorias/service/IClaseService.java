package net.ipn.tutorias.service;

import java.util.List;

import net.ipn.tutorias.model.CClase;

public interface IClaseService {
	List<CClase> buscarTodos();
	CClase obtenerPorId(int id);
	void guardar(CClase clase);
	void eliminarClase(int id);

}
