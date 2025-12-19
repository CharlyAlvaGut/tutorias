package net.ipn.tutorias.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import net.ipn.tutorias.model.CPublicacion;

public interface IPublicacionRepository extends JpaRepository<CPublicacion, Integer> {
	
	@Query(value = """
		    SELECT 
			   CONCAT(b.nombre,' ',b.apellidop,' ',b.apellidom) AS nombre,
			   a.descripcion,
			   a.fecha,
			   GROUP_CONCAT(c.id ORDER BY c.id SEPARATOR ',') AS documentos
			FROM publicaciones a
			INNER JOIN usuarios b ON a.idUsuario = b.id
			LEFT JOIN documentos c ON c.idPublicacion = a.id
			WHERE a.idClase = :idClase GROUP BY a.id
	""", nativeQuery = true)
	List<Object[]> obtenerPublicaciones(@Param("idClase") Integer clase);
}
