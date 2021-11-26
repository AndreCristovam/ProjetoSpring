package br.com.primeiroprojetospring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.primeiroprojetospring.domain.Professor;
import br.com.primeiroprojetospring.repository.ProfessorRepository;

@Service
public class ProfessorService {

	@Autowired
	private ProfessorRepository professorRepository;

	public List<Professor> buscarTodosProfessores() {
		return professorRepository.findAll();
	}

	public Professor salvar(Professor professor) {
		return professorRepository.save(professor);
	}

}
