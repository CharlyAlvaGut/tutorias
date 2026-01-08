package net.ipn.tutorias.service.db;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import net.ipn.tutorias.dto.PublicacionDTO;
import net.ipn.tutorias.model.CFlujo;
import net.ipn.tutorias.model.CPublicacion;
import net.ipn.tutorias.repository.IPublicacionRepository;
import net.ipn.tutorias.service.IPublicacionService;

@Service
@Primary
public class PublicacionService implements IPublicacionService {
	@Autowired
	private IPublicacionRepository repoPublicacion;

	@Override
	public CPublicacion guardar(CPublicacion publicacion) {
		return repoPublicacion.save(publicacion);

	}

	@Override
	public List<PublicacionDTO> buscarPublicacionesPorClase(Integer clase) {
		List<Object[]> resultados = repoPublicacion.obtenerPublicaciones(clase);

		return resultados.stream().map(r -> new PublicacionDTO(((Integer) r[0]).intValue(), (String) r[1],
				(String) r[2], (Date) r[3], (String) r[4])).toList();
	}
}
