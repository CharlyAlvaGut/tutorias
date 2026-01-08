package net.ipn.tutorias.service.db;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import net.ipn.tutorias.dto.FlujoDTO;
import net.ipn.tutorias.model.CFlujo;
import net.ipn.tutorias.repository.IFlujoRepository;
import net.ipn.tutorias.service.IFlujoService;

@Service
@Primary
public class FlujoService implements IFlujoService {
	
	@Autowired
	private IFlujoRepository repoFlujo;

	@Override
	public void guardar(CFlujo flujo) {
		repoFlujo.save(flujo);
	}

	@Override
	public List<FlujoDTO> obtenerFlujos(Integer documento) {
		List<Object[]> resultados = repoFlujo.obtenerFlujo(documento);

		return resultados.stream().map(
				r -> new FlujoDTO(((Integer) r[0]).intValue(), (String) r[1], (String) r[2], (Date) r[3]))
				.toList();
	}

}
