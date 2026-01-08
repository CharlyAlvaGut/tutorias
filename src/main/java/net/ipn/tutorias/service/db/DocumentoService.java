package net.ipn.tutorias.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import net.ipn.tutorias.dto.DocumentoDTO;
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

	@Override
	public List<DocumentoDTO> obtenerDocumentos(Integer id) {
		List<Object[]> resultados = repoDocumento.obtenerDocumentos(id);

		return resultados.stream().map(
				r -> new DocumentoDTO(((Integer) r[0]).intValue(), (String) r[1]))
				.toList();
	}

	@Override
	public CDocumento obtenerPorId(Integer id) {
		Optional<CDocumento> optional = repoDocumento.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
}
