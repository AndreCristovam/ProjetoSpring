package br.com.primeiroprojetospring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.primeiroprojetospring.domain.Acessorio;
import br.com.primeiroprojetospring.service.AcessorioService;

@Controller
@RequestMapping("acessorio")
public class AcessorioController {
	
	@Autowired
	private AcessorioService acessorioService;
	
	@GetMapping("/listaAcessorios")
	public ModelAndView  listaTodosAcessorio() {
		ModelAndView mView = new ModelAndView("acessorio/paginaListaAcessorios");
		mView.addObject("acessorio", acessorioService.buscarTodosAcessorios());
		return mView;
	}
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrarAcessorio() {
		ModelAndView mView = new ModelAndView("acessorio/cadastrarAcessorio");
		mView.addObject("acessorio", new Acessorio());
		return mView;
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvarAcessorio(Acessorio acessorio) {
		acessorioService.salvar(acessorio);
		return listaTodosAcessorio();
	}
	
	@GetMapping("/alterar/{id}")
	public ModelAndView alteraAcessorio(@PathVariable("id") Integer idAcessorio) {
		ModelAndView mView = new ModelAndView("acessorio/alteraAcessorio");
		mView.addObject("acessorio", acessorioService.buscarAcessorioID(idAcessorio));
		return mView;
	}
	
	@PostMapping("/alterar")
	public ModelAndView alterar(Acessorio acessorioAlterado) {
		acessorioService.salvarAlteracao(acessorioAlterado);
		return listaTodosAcessorio();
	}
	
	@GetMapping("/excluir/{id}")
	public ModelAndView excluir(@PathVariable("id") Integer id) {
		acessorioService.excluir(id);
		return listaTodosAcessorio();
	}

}
