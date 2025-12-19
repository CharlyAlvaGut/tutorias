package net.ipn.tutorias.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.ipn.tutorias.model.CDocumento;

public interface IDocumentoRepository extends JpaRepository<CDocumento, Integer> {

}
