package net.ipn.tutorias.service;

import java.util.List;

import net.ipn.tutorias.dto.DocumentoDTO;
import net.ipn.tutorias.model.CDocumento;

public interface IDocumentoService {
	CDocumento guardar (CDocumento documento);
	List<DocumentoDTO> obtenerDocumentos(Integer id);
	CDocumento obtenerPorId (Integer id);
}
