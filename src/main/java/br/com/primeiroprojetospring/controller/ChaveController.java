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

import br.com.primeiroprojetospring.domain.Chave;
import br.com.primeiroprojetospring.service.ChaveService;

@RestController
@RequestMapping("chave")
public class ChaveController {

	private static final String CHAVE = "chave";
	
	@Autowired
	private ChaveService chaveService;
	
	@GetMapping("find/{id}")
	public ResponseEntity<Chave> find(@PathVariable("id") Integer id){
		return ResponseEntity.ok().body(chaveService.buscarChaveID(id));
	}
	
	@PostMapping("cadastrarChave")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Chave> cadastrarChaveAPI(@RequestBody Chave chave){
		return ResponseEntity.ok().body(chaveService.salvar(chave));
	}
	
	@GetMapping("/todosChave")
	public ResponseEntity<List<Chave>> devolverTodosChave(){
		return ResponseEntity.ok().body(chaveService.buscarTodasChaves());
	}
	
	@PutMapping("/alteraChave")
	public ResponseEntity<Chave> alteraChave(@RequestBody Chave chave){
		Chave novoChave = chaveService.salvar(chave);
		return ResponseEntity.status(HttpStatus.CREATED).body(novoChave);
	}
	
	
	@GetMapping("/listaChave")
	public ModelAndView  listaTodasChaves() {
		ModelAndView mView = new ModelAndView("chave/paginaListaChave");
		mView.addObject(CHAVE, chaveService.buscarTodasChaves());
		return mView;
	}
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrarChave() {
		ModelAndView mView = new ModelAndView("chave/cadastrarChave");
		mView.addObject(CHAVE, new Chave());
		return mView;
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvarChave(Chave chave) {
		chaveService.salvar(chave);
		return listaTodasChaves();
	}
	
	@GetMapping("/alterar/{id}")
	public ModelAndView alteraChave(@PathVariable("id") Integer idChave) {
		ModelAndView mView = new ModelAndView("chave/alteraChave");
		mView.addObject(CHAVE, chaveService.buscarChaveID(idChave));
		return mView;
	}
	
	@PostMapping("/alterar")
	public ModelAndView alterar(Chave chaveAlterada) {
		chaveService.salvarAlteracao(chaveAlterada);
		return listaTodasChaves();
	}
	
	@GetMapping("/excluir/{id}")
	public ModelAndView excluir(@PathVariable("id") Integer id) {
		chaveService.excluir(id);
		return listaTodasChaves();
	}
}
