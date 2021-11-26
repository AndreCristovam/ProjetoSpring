package br.com.primeiroprojetospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.primeiroprojetospring.domain.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer>{
	// segunda camada do MVC criar as interfaces e extender o JPA
	
}
