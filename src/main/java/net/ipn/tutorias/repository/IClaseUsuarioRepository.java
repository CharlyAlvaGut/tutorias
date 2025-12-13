package net.ipn.tutorias.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.ipn.tutorias.model.CClaseUsuario;
import net.ipn.tutorias.model.ClaseUsuarioPK;

public interface IClaseUsuarioRepository extends JpaRepository<CClaseUsuario, ClaseUsuarioPK>{
	 boolean existsByIdClaseAndIdUsuario(Integer idClase, Integer idUsuario);
}
