package br.com.primeiroprojetospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.primeiroprojetospring.domain.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {

}
