package br.com.primeiroprojetospring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.primeiroprojetospring.domain.Aluno;
import br.com.primeiroprojetospring.repository.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	public List<Aluno> buscarTodosAlunos() {
		return alunoRepository.findAll();
	}
	
	public Aluno salvar(Aluno aluno) {
		return alunoRepository.save(aluno);
	}

}
