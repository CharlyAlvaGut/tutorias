package net.ipn.tutorias.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import net.ipn.tutorias.model.CClase;
import net.ipn.tutorias.repository.IClaseRepository;
import net.ipn.tutorias.service.IClaseService;

@Service
@Primary
public class ClaseService implements IClaseService{
	
	@Autowired
	private IClaseRepository repoClases;

	@Override
	public List<CClase> buscarTodos() {
		List<CClase> lista = repoClases.findAll();
		return lista;
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

}
