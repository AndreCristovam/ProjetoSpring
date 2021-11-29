package br.com.primeiroprojetospring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.primeiroprojetospring.domain.Aluno;
import br.com.primeiroprojetospring.service.AlunoService;

@Controller
@RequestMapping("aluno")
public class AlunoController {
	
	@Autowired
	private AlunoService alunoService;
	
	@GetMapping("/listaAlunos")
	public ModelAndView  listaTodosAluno() {
		ModelAndView mView = new ModelAndView("aluno/paginaListaAlunos");
		mView.addObject("aluno", alunoService.buscarTodosAlunos());
		return mView;
	}
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrarAluno() {
		ModelAndView mView = new ModelAndView("aluno/cadastrarAluno");
		mView.addObject("aluno", new Aluno());
		return mView;
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvarAluno(Aluno aluno) {
		alunoService.salvar(aluno);
		return listaTodosAluno();
	}

}
