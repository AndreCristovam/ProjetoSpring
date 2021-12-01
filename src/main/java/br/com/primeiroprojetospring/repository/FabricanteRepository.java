package br.com.primeiroprojetospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.primeiroprojetospring.domain.Fabricante;

@Repository
public interface FabricanteRepository extends JpaRepository<Fabricante, Integer>{
		
}
