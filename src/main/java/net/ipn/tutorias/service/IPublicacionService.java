package net.ipn.tutorias.service;

import java.util.List;

import net.ipn.tutorias.dto.PublicacionDTO;
import net.ipn.tutorias.model.CPublicacion;

public interface IPublicacionService {
	CPublicacion guardar(CPublicacion publicacion);
	List<PublicacionDTO> buscarTodos();
}
