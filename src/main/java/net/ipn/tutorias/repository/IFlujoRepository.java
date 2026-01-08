package net.ipn.tutorias.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import net.ipn.tutorias.model.CFlujo;

public interface IFlujoRepository extends JpaRepository<CFlujo, Integer>{
	
	@Query(value = """
		    SELECT
		      a.id,
			  CONCAT(b.nombre,' ',b.apellidop,' ', b.apellidom) AS nombre,
			  c.nombre,
			  a.fecha
			FROM
			  flujoestatus a
			  INNER JOIN usuarios b ON a.idUsuario = b.id
			  INNER JOIN estatus c ON a.idEstatus = c.id
			WHERE
			  a.idDocumento = :idDocumento ORDER BY a.fecha DESC
	""", nativeQuery = true)
	List<Object[]> obtenerFlujo(@Param("idDocumento") Integer documento);
}
