package br.com.primeiroprojetospring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.primeiroprojetospring.domain.Acessorio;
import br.com.primeiroprojetospring.service.AcessorioService;

@RestController
@RequestMapping("acessorio")
public class AcessorioController {
	
	private static final String ACESSORIO = "acessorio";
	
	@Autowired
	private AcessorioService acessorioService; 
	
	@GetMapping("find/{id}")
	public ResponseEntity<Acessorio> find(@PathVariable("id") Integer id){
		return ResponseEntity.ok().body(acessorioService.buscarAcessorioID(id));
	}
	
	@PostMapping("cadastrarAcessorio")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Acessorio> cadastrarAcessorioAPI(@RequestBody Acessorio acessorio){
		return ResponseEntity.ok().body(acessorioService.salvar(acessorio));
	}
	
	@GetMapping("/todosAcessorio")
	public ResponseEntity<List<Acessorio>> devolverTodosAcessorios(){
		return ResponseEntity.ok().body(acessorioService.buscarTodosAcessorios());
	}
	
	@PutMapping("/alteraAcessorio")
	public ResponseEntity<Acessorio> alteraAcessorio(@RequestBody Acessorio acessorio){
		Acessorio novoAcessorio = acessorioService.salvar(acessorio);
		return ResponseEntity.status(HttpStatus.CREATED).body(novoAcessorio);
	}
	
	@GetMapping("/listaAcessorios")
	public ModelAndView  listaTodosAcessorio() {
		ModelAndView mView = new ModelAndView("acessorio/paginaListaAcessorios");
		mView.addObject(ACESSORIO, acessorioService.buscarTodosAcessorios());
		return mView;
	}
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrarAcessorio() {
		ModelAndView mView = new ModelAndView("acessorio/cadastrarAcessorio");
		mView.addObject(ACESSORIO, new Acessorio());
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
		mView.addObject(ACESSORIO, acessorioService.buscarAcessorioID(idAcessorio));
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
