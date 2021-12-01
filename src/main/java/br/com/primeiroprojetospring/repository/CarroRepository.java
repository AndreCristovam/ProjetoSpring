package br.com.primeiroprojetospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.primeiroprojetospring.domain.Carro;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Integer>{
	
	
}
