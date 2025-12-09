package net.ipn.tutorias.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import net.ipn.tutorias.model.Clase;
import net.ipn.tutorias.repository.ClaseRepository;
import net.ipn.tutorias.service.IClaseService;

@Service
@Primary
public class ClaseService implements IClaseService{
	
	@Autowired
	private ClaseRepository repoClases;

	@Override
	public List<Clase> buscarTodos() {
		List<Clase> lista = repoClases.findAll();
		return lista;
	}

	@Override
	public Clase obtenerPorId(int id) {
		Optional<Clase> optional = repoClases.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public void guardar(Clase clase) {
		repoClases.save(clase);

	}

	@Override
	public void eliminarClase(int id) {
		repoClases.deleteById(id);

	}
}