package br.com.primeiroprojetospring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.primeiroprojetospring.domain.Aluno;
import br.com.primeiroprojetospring.service.AlunoService;

@RestController
@RequestMapping("aluno")
public class AlunoController {
	
	private static final String ALUNO = "aluno";
	
	@Autowired
	private AlunoService alunoService;	
	
	
	@GetMapping("find/{id}")
	public ResponseEntity<Aluno> find(@PathVariable("id") Integer id){
		return ResponseEntity.ok().body(alunoService.buscarPorID(id));
	}
	
	//novo
	@GetMapping("/findByNome/{nome}")
	public ResponseEntity<List<Aluno>> findByNome(@PathVariable("nome") String nome) {
		return ResponseEntity.ok().body(alunoService.buscaPorNome(nome));
	}
	
	//novo
	@DeleteMapping("exluirAluno/{id}")
	public ResponseEntity<Void> excluirP(@PathVariable("id") Integer id){
		alunoService.excluir(id);
		return ResponseEntity.noContent().build();
	}
	
	//novo
	@GetMapping("/findByNomeStartWith/{inicio}/{fim}")
	public ResponseEntity<List<Aluno>> findByNomeStartWithAndEndWith(@PathVariable("inicio") String inicio,
			@PathVariable("fim") String fim) {
		return ResponseEntity.ok().body(alunoService.findAlunoStartWithAndEndWith(inicio, fim));
	}
	
	
	@PostMapping("cadastrarAluno")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Aluno> cadastrarAlunoAPI(@RequestBody Aluno aluno){
		return ResponseEntity.ok().body(alunoService.salvar(aluno));
	}
	
	@GetMapping("/todosAluno")
	public ResponseEntity<List<Aluno>> devolverTodosAlunos(){
		return ResponseEntity.ok().body(alunoService.buscarTodosAlunos());
	}
	
	@PutMapping("/alteraAluno")
	public ResponseEntity<Aluno> alteraAluno(@RequestBody Aluno aluno){
		Aluno novoAluno = alunoService.salvar(aluno);
		return ResponseEntity.status(HttpStatus.CREATED).body(novoAluno);
	}	
	
	@GetMapping("/listaAlunos")
	public ModelAndView  listaTodosAluno() {
		ModelAndView mView = new ModelAndView("aluno/paginaListaAlunos");
		mView.addObject(ALUNO, alunoService.buscarTodosAlunos());
		return mView;
	}
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrarAluno() {
		ModelAndView mView = new ModelAndView("aluno/cadastrarAluno");
		mView.addObject(ALUNO, new Aluno());
		return mView;
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvarAluno(Aluno aluno) {
		alunoService.salvar(aluno);
		return listaTodosAluno();
	}
	
	@GetMapping("/alterar/{id}")
	public ModelAndView alteraAluno(@PathVariable("id") Integer idAluno) {
		ModelAndView mView = new ModelAndView("aluno/alteraAluno");
		mView.addObject(ALUNO, alunoService.buscarPorID(idAluno));
		return mView;
	}
	
	@PostMapping("/alterar")
	public ModelAndView alterar(Aluno alunoAlterado) {
		alunoService.salvarAlteracao(alunoAlterado);
		return listaTodosAluno();
	}
	
	@GetMapping("/excluir/{id}")
	public ModelAndView excluir(@PathVariable("id") Integer id) {
		alunoService.excluir(id);
		return listaTodosAluno();
	}

}
