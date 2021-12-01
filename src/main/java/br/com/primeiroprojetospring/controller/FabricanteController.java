package br.com.primeiroprojetospring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.primeiroprojetospring.domain.Fabricante;
import br.com.primeiroprojetospring.service.FabricanteService;

@Controller
@RequestMapping("fabricante")
public class FabricanteController {
	
	@Autowired
	private FabricanteService fabricanteService;
	
	@GetMapping("/listaFabricantes")
	public ModelAndView  listaTodosFabricante() {
		ModelAndView mView = new ModelAndView("fabricante/paginaListaFabricantes");
		mView.addObject("fabricante", fabricanteService.buscarTodosFabricantes());
		return mView;
	}
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrarFabricante() {
		ModelAndView mView = new ModelAndView("fabricante/cadastrarFabricante");
		mView.addObject("fabricante", new Fabricante());
		return mView;
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvarFabricante(Fabricante fabricante) {
		fabricanteService.salvar(fabricante);
		return listaTodosFabricante();
	}
	
	@GetMapping("/alterar/{id}")
	public ModelAndView alteraFabricante(@PathVariable("id") Integer idFabricante) {
		ModelAndView mView = new ModelAndView("fabricante/alteraFabricante");
		mView.addObject("fabricante", fabricanteService.buscarFabricanteID(idFabricante));
		return mView;
	}
	
	@PostMapping("/alterar")
	public ModelAndView alterar(Fabricante fabricanteAlterado) {
		fabricanteService.salvarAlteracao(fabricanteAlterado);
		return listaTodosFabricante();
	}
	
	@GetMapping("/excluir/{id}")
	public ModelAndView excluir(@PathVariable("id") Integer id) {
		fabricanteService.excluir(id);
		return listaTodosFabricante();
	}

}
