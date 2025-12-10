package net.ipn.tutorias.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.ipn.tutorias.model.CUsuario;

public interface IUsuarioRepository extends JpaRepository<CUsuario, Integer>{
	CUsuario findByCorreo(String correo);
}
