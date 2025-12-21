package net.ipn.tutorias.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import net.ipn.tutorias.model.CClase;

public interface IClaseRepository extends JpaRepository<CClase, Integer> {

	@Query(value = """
    			SELECT
			    a.id,
			    a.titulo,
			    a.descripcion,
			    CONCAT(b.nombre, ' ', b.apellidop, ' ', b.apellidom) AS usuario,
			    a.fecha
			FROM clases a
			INNER JOIN usuarios b ON a.idUsuario = b.id
			LEFT JOIN claseusuarios c
			    ON a.id = c.idClase
			    AND c.idUsuario = :idUser
			WHERE c.idUsuario IS NULL;

						""", nativeQuery = true)
	List<Object[]> obtenerClases(@Param("idUser") Integer user);

	@Query(value = """
			   SELECT
			       a.id,
			       a.titulo,
			       a.descripcion,
			       CONCAT(b.nombre, ' ', b.apellidop, ' ', b.apellidom) AS usuario,
			       a.fecha
			FROM clases a
			INNER JOIN usuarios b ON a.idUsuario = b.id
			INNER JOIN claseusuarios c ON a.id = c.idClase
			WHERE c.idUsuario = :idUser
							""", nativeQuery = true)
	List<Object[]> obtenerClasesPorUsuario(@Param("idUser") Integer user);

	@Query(value = """
			  SELECT
				a.id,
				a.titulo,
				a.descripcion,
				CONCAT(b.nombre, ' ', b.apellidop, ' ', b.apellidom) AS usuario,
				a.fecha
			FROM clases a
			INNER JOIN usuarios b ON a.idUsuario = b.id
			WHERE a.idUsuario = :idUser
										""", nativeQuery = true)
	List<Object[]> obtenerClasesCreadas(@Param("idUser") Integer user);

}
