package net.ipn.tutorias.service.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import net.ipn.tutorias.model.CUsuario;
import net.ipn.tutorias.repository.IUsuarioRepository;
import net.ipn.tutorias.service.IUsuarioService;

@Service
@Primary
public class UsuarioService implements IUsuarioService{

	@Autowired
	private IUsuarioRepository repoUsuarios;
	
	@Override
	public void guardar(CUsuario usuario) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		usuario.setPassword(encoder.encode(usuario.getPassword()));
		usuario.setEstatus(1);
		repoUsuarios.save(usuario);
		
	}

	@Override
	public CUsuario obtenerPorCorreo(String correo) {
		return repoUsuarios.findByCorreo(correo);
	}
	
}
