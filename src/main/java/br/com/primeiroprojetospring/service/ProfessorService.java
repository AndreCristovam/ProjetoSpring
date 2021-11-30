package br.com.primeiroprojetospring.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
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
	
	public Professor buscarProfessorID(Integer id) {
		Optional<Professor> professor = professorRepository.findById(id);
		return professor.orElseThrow(() -> new ObjectNotFoundException(new Professor(), "Professor não encontrado. Id: "+id));
	}
	
	public Professor salvarAlteracao(Professor professorAlterado) throws ObjectNotFoundException {
		Professor professor = buscarProfessorID(professorAlterado.getId());
		professor.setId(professorAlterado.getId());
		professor.setNome(professorAlterado.getNome());
		return salvar(professor);
	}

	public void excluir(Integer id) {
		professorRepository.deleteById(id);
	}
}
