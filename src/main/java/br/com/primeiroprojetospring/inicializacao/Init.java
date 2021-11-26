package br.com.primeiroprojetospring.inicializacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.primeiroprojetospring.domain.Aluno;
import br.com.primeiroprojetospring.domain.Professor;
import br.com.primeiroprojetospring.repository.AlunoRepository;
import br.com.primeiroprojetospring.repository.ProfessorRepository;
import br.com.primeiroprojetospring.service.AlunoService;
import br.com.primeiroprojetospring.service.ProfessorService;


@Component
public class Init implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private AlunoService alunoService;
	
	
	@Autowired
	private ProfessorService professorService;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		Aluno aluno1 = new Aluno();
		aluno1.setNome("Sandro Nelson");
		alunoService.salvar(aluno1);
		
		Aluno aluno2 = new Aluno();
		aluno2.setNome("Raquel");
		alunoService.salvar(aluno1);
		
		Aluno aluno3 = new Aluno();
		aluno3.setNome("Douglas das Neves");
		alunoService.salvar(aluno3);
		
		//List<Aluno> listaAluno = alunoRepository.findAll();
		List<Aluno> listaAluno = alunoService.buscarTodosAlunos();
		
		for (Aluno aluno : listaAluno ) {
			System.out.println(aluno.getNome());
		}
		
		
		Professor professor1 = new Professor();
		professor1.setNome("Yuri");
		professorService.salvar(professor1);
		
		Professor professor2 = new Professor();
		professor2.setNome("Marcelo");
		professorService.salvar(professor2);
		
		Professor professor3 = new Professor();
		professor3.setNome("Nelson");
		professorService.salvar(professor3);
		
		
		List<Professor> listaProfessor = professorService.buscarTodosProfessores();
		
		for (Professor professor : listaProfessor ) {
			System.out.println(professor.getNome());
		}
		
	}	
	
}
