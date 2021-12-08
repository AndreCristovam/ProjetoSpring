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

import br.com.primeiroprojetospring.domain.Documento;
import br.com.primeiroprojetospring.service.DocumentoService;

@RestController
@RequestMapping("documento")
public class DocumentoController {
	
	private static final String DOCUMENTO = "documento";
	
	@Autowired
	private DocumentoService documentoService;
	
	
	@GetMapping("find/{id}")
	public ResponseEntity<Documento> find(@PathVariable("id") Integer id){
		return ResponseEntity.ok().body(documentoService.buscarDocumentoID(id));
	}	
	
	@PostMapping("cadastrarDocumento")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Documento> cadastrarDocumentoAPI(@RequestBody Documento documento){
		return ResponseEntity.ok().body(documentoService.salvar(documento));
	}
	
	@GetMapping("/todosDocumento")
	public ResponseEntity<List<Documento>> devolverTodosDocumentos(){
		return ResponseEntity.ok().body(documentoService.buscarTodosDocumentos());
	}
	
	@PutMapping("/alteraDocumento")
	public ResponseEntity<Documento> alteraDocumento(@RequestBody Documento documento){
		Documento novoDocumento = documentoService.salvar(documento);
		return ResponseEntity.status(HttpStatus.CREATED).body(novoDocumento);
	}	
	
	@GetMapping("/listaDocumentos")
	public ModelAndView  listaTodosDocumento() {
		ModelAndView mView = new ModelAndView("documento/paginaListaDocumentos");
		mView.addObject(DOCUMENTO, documentoService.buscarTodosDocumentos());
		return mView;
	}
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrarDocumento() {
		ModelAndView mView = new ModelAndView("documento/cadastrarDocumento");
		mView.addObject(DOCUMENTO, new Documento());
		return mView;
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvarDocumento(Documento documento) {
		documentoService.salvar(documento);
		return listaTodosDocumento();
	}
	
	@GetMapping("/alterar/{id}")
	public ModelAndView alteraDocumento(@PathVariable("id") Integer idDocumento) {
		ModelAndView mView = new ModelAndView("documento/alteraDocumento");
		mView.addObject(DOCUMENTO, documentoService.buscarDocumentoID(idDocumento));
		return mView;
	}
	
	@PostMapping("/alterar")
	public ModelAndView alterar(Documento documentoAlterado) {
		documentoService.salvarAlteracao(documentoAlterado);
		return listaTodosDocumento();
	}
	
	@GetMapping("/excluir/{id}")
	public ModelAndView excluir(@PathVariable("id") Integer id) {
		documentoService.excluir(id);
		return listaTodosDocumento();
	}
	
	@GetMapping("/findByNomeAndCodigoDocumento/{nome}/{codigo}")
	public ResponseEntity<List<Documento>> findByNomeAndCodigoDocumento(@PathVariable("nome") String nome,
			@PathVariable("codigo") String codigo) {
		return ResponseEntity.ok().body(documentoService.findDocumentoNomeAndCodigo(nome, codigo));
	}

}
