package br.com.primeiroprojetospring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.primeiroprojetospring.domain.Professor;
import br.com.primeiroprojetospring.service.ProfessorService;

@Controller
@RequestMapping("professor")
public class ProfessorController {
	
	private static final String PROFESSOR = "professor";
	
	@Autowired
	private ProfessorService professorService;
	
	@GetMapping("/listaProfessor")
	public ModelAndView listaTodosProfessores() {
		ModelAndView mView = new ModelAndView("professor/paginaListaProfessores");
		mView.addObject(PROFESSOR, professorService.buscarTodosProfessores());
		return mView;
	}

	@GetMapping("/cadastrar")
	public ModelAndView cadastrarProfessor() {
		ModelAndView mView = new ModelAndView("professor/cadastrarProfessor");
		mView.addObject(PROFESSOR, new Professor());
		return mView;
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvarProfessor(Professor professor) {
		professorService.salvar(professor);
		return listaTodosProfessores();
	}
	
	@GetMapping("/alterar/{id}")
	public ModelAndView alteraProfessor(@PathVariable("id") Integer idProfessor) {
		ModelAndView mView = new ModelAndView("professor/alteraProfessor");
		mView.addObject(PROFESSOR, professorService.buscarProfessorID(idProfessor));
		return mView;
	}
	
	@PostMapping("/alterar")
	public ModelAndView alterar(Professor professorAlterado) {
		professorService.salvarAlteracao(professorAlterado);
		return listaTodosProfessores();
	}
	
	@GetMapping("/excluir/{id}")
	public ModelAndView excluir(@PathVariable("id") Integer id) {
		professorService.excluir(id);
		return listaTodosProfessores();
	}
}
