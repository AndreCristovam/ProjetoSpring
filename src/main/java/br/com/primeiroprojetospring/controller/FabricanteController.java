package br.com.primeiroprojetospring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import br.com.primeiroprojetospring.domain.Fabricante;
import br.com.primeiroprojetospring.service.FabricanteService;

@Controller
@RequestMapping("fabricante")
public class FabricanteController {
	
	private static final String FABRICANTE = "fabricante";
	
	@Autowired
	private FabricanteService fabricanteService;
	
	@GetMapping("find/{id}")
	public ResponseEntity<Fabricante> find(@PathVariable("id") Integer id){
		return ResponseEntity.ok().body(fabricanteService.buscarFabricanteID(id));
	}	
	
	@PostMapping("cadastrarFabricante")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Fabricante> cadastrarFabricanteAPI(@RequestBody Fabricante fabricante){
		return ResponseEntity.ok().body(fabricanteService.salvar(fabricante));
	}
	
	@GetMapping("/todosFabricante")
	public ResponseEntity<List<Fabricante>> devolverTodosFabricantes(){
		return ResponseEntity.ok().body(fabricanteService.buscarTodosFabricantes());
	}
	
	@PutMapping("/alteraFabricante")
	public ResponseEntity<Fabricante> alteraFabricante(@RequestBody Fabricante fabricante){
		Fabricante novoFabricante = fabricanteService.salvar(fabricante);
		return ResponseEntity.status(HttpStatus.CREATED).body(novoFabricante);
	}
	
	
	@GetMapping("/listaFabricantes")
	public ModelAndView  listaTodosFabricante() {
		ModelAndView mView = new ModelAndView("fabricante/paginaListaFabricantes");
		mView.addObject(FABRICANTE, fabricanteService.buscarTodosFabricantes());
		return mView;
	}
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrarFabricante() {
		ModelAndView mView = new ModelAndView("fabricante/cadastrarFabricante");
		mView.addObject(FABRICANTE, new Fabricante());
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
		mView.addObject(FABRICANTE, fabricanteService.buscarFabricanteID(idFabricante));
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
	
	@GetMapping("findFabricanteForPais/{pais}")
	public ResponseEntity<List<Fabricante>> findFabricantePais(@PathVariable("pais") String pais){
		return ResponseEntity.ok().body(fabricanteService.findFabricanteForPais(pais));
	}

}
