package net.ipn.tutorias.service;

import java.util.List;

import net.ipn.tutorias.dto.FlujoDTO;
import net.ipn.tutorias.model.CFlujo;

public interface IFlujoService {
	void guardar(CFlujo flujo);
	List<FlujoDTO> obtenerFlujos (Integer documento);
}
