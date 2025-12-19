package net.ipn.tutorias.service.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import net.ipn.tutorias.model.CDocumento;
import net.ipn.tutorias.repository.IDocumentoRepository;
import net.ipn.tutorias.service.IDocumentoService;

@Service
@Primary
public class DocumentoService implements IDocumentoService{
	@Autowired
	private IDocumentoRepository repoDocumento;

	@Override
	public CDocumento guardar(CDocumento documento) {
		return repoDocumento.save(documento);
	}
}
