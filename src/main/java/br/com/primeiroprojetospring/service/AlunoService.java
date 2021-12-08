package br.com.primeiroprojetospring.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.querydsl.jpa.impl.JPAQueryFactory;

import br.com.primeiroprojetospring.domain.Aluno;
import br.com.primeiroprojetospring.domain.QAluno;
import br.com.primeiroprojetospring.repository.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	@Autowired
	private EntityManager entityManager;
	
	public List<Aluno> buscarTodosAlunos() {
		
		return alunoRepository.findAll();
		
	}

	public Aluno salvar(Aluno aluno) {
		
		return alunoRepository.save(aluno);
	}
	
	public List<Aluno> buscaPorNome(String nome) {

		return alunoRepository.findByNomeAlunoJPQL(nome);
	}
	
	public Aluno buscarPorID(Integer id) throws ObjectNotFoundException {
		Optional<Aluno> aluno = alunoRepository.findById(id);
		return aluno.orElseThrow(() -> 
		new ObjectNotFoundException(new Aluno(), "Aluno não encontrado. id: " + id));
	}
	
	public Aluno salvarAlteracao(Aluno alunoAlterado) throws ObjectNotFoundException {
		Aluno aluno = buscarPorID(alunoAlterado.getId());
		aluno.setId(alunoAlterado.getId());
		aluno.setNome(alunoAlterado.getNome());
		return salvar(aluno);
		
	}
	
	public void excluir(Integer id) {
		alunoRepository.deleteById(id);
	}
	
	public List<Aluno> findAlunoStartWithAndEndWith(String inicial, String fim) {
		QAluno aluno = QAluno.aluno;
		
		return new JPAQueryFactory(entityManager).selectFrom(aluno)
		.where(aluno.nome.startsWith(inicial).and(aluno.nome.endsWith(fim))).fetch();
	}
}