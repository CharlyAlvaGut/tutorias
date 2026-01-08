package net.ipn.tutorias.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import net.ipn.tutorias.model.CDocumento;

public interface IDocumentoRepository extends JpaRepository<CDocumento, Integer> {
	@Query(value = """
		    SELECT 
			   a.id,
			   a.nombre
			FROM documentos a
			WHERE a.idPublicacion = :idPublicacion ORDER BY a.id ASC
	""", nativeQuery = true)
	List<Object[]> obtenerDocumentos(@Param("idPublicacion") Integer publicacion);
}
