package net.ipn.tutorias.service.db;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import net.ipn.tutorias.dto.ClaseDTO;
import net.ipn.tutorias.model.CClase;
import net.ipn.tutorias.repository.IClaseRepository;
import net.ipn.tutorias.service.IClaseService;

@Service
@Primary
public class ClaseService implements IClaseService {

	@Autowired
	private IClaseRepository repoClases;

	@Override
	public List<ClaseDTO> buscarTodos() {
		List<Object[]> resultados = repoClases.obtenerClases();

		return resultados.stream().map(
				r -> new ClaseDTO(((Number) r[0]).intValue(), (String) r[1], (String) r[2], (String) r[3], (Date) r[4]))
				.toList();
	}

	@Override
	public CClase obtenerPorId(int id) {
		Optional<CClase> optional = repoClases.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public void guardar(CClase clase) {
		repoClases.save(clase);

	}

	@Override
	public void eliminarClase(int id) {
		repoClases.deleteById(id);

	}

	@Override
	public List<ClaseDTO> buscarPorId(Integer user) {
		List<Object[]> resultados = repoClases.obtenerClasesPorUsuario(user);

		return resultados.stream().map(
				r -> new ClaseDTO(((Number) r[0]).intValue(), (String) r[1], (String) r[2], (String) r[3], (Date) r[4]))
				.toList();
	}

}
