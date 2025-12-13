package net.ipn.tutorias.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import net.ipn.tutorias.model.CClase;

public interface IClaseRepository extends JpaRepository<CClase, Integer> {

	@Query(value = """
				    SELECT
				        c.id,
				        c.titulo,
				        c.descripcion,
				        CONCAT(u.nombre, ' ', u.apellidop, ' ', u.apellidom) AS usuario,
				        c.fecha
				    FROM clases c
				    JOIN usuarios u ON c.idUsuario = u.id
				    WHERE c.estatus = 1
			""", nativeQuery = true)
	List<Object[]> obtenerClases();

}
