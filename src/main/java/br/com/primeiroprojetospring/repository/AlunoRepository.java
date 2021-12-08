package br.com.primeiroprojetospring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.primeiroprojetospring.domain.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer>{
	
	@Query("SELECT a "
			+"FROM Aluno a "
			+"WHERE a.nome = :nomeAluno")	
	List<Aluno> findByNomeAlunoJPQL(@Param("nomeAluno") String nomeAluno);
	
}
