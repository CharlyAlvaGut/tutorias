package net.ipn.tutorias.service;

import java.util.List;

import net.ipn.tutorias.model.Clase;

public interface IClaseService {
	List<Clase> buscarTodos();
	Clase obtenerPorId(int id);
	void guardar(Clase clase);
	void eliminarClase(int id);
}
