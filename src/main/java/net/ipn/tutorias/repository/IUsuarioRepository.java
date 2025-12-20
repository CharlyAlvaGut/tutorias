package net.ipn.tutorias.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import net.ipn.tutorias.model.CUsuario;

public interface IUsuarioRepository extends JpaRepository<CUsuario, Integer> {
	CUsuario findByCorreo(String correo);

	@Query(value = """
   			SELECT
				a.id,		
				CONCAT(a.nombre,' ',a.apellidop,' ', a.apellidom) AS nombre,
				a.correo
			FROM usuarios a
			JOIN claseusuarios b ON a.id = b.idUsuario 
			WHERE b.idClase = :idClase
										""", nativeQuery = true)
	List<Object[]> obtenerUsuariosPorClases(@Param("idClase") Integer clase);
}
