package br.com.primeiroprojetospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.primeiroprojetospring.domain.Documento;

@Repository
public interface DocumentoRepository extends JpaRepository<Documento, Integer>{

}
