package net.ipn.tutorias.service.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import net.ipn.tutorias.model.CClaseUsuario;
import net.ipn.tutorias.model.ClaseUsuarioPK;
import net.ipn.tutorias.repository.IClaseUsuarioRepository;
import net.ipn.tutorias.service.IClaseUsuarioService;

@Service
@Primary
public class ClaseUsuarioService implements IClaseUsuarioService {

	@Autowired
	private IClaseUsuarioRepository repo;

	@Override
	public boolean inscribir(Integer idClase, Integer idUsuario) {
		if (repo.existsByIdClaseAndIdUsuario(idClase, idUsuario)) {
			return false;
		}

		repo.save(new CClaseUsuario(idClase, idUsuario));
		return true;
	}

	@Override
	public boolean eliminar(Integer idClase, Integer idUsuario) {
		if (!repo.existsByIdClaseAndIdUsuario(idClase, idUsuario)) {
			return false; 
		}

		repo.deleteById(new ClaseUsuarioPK(idClase, idUsuario));
		return true; 
	}

}
