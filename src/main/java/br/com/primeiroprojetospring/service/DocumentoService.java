package br.com.primeiroprojetospring.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.primeiroprojetospring.domain.Documento;
import br.com.primeiroprojetospring.repository.DocumentoRepository;

@Service
public class DocumentoService {
	
	@Autowired
	private DocumentoRepository documentoRepository;
	
	public List<Documento> buscarTodosDocumentos() {
		return documentoRepository.findAll();
	}
	
	public Documento salvar(Documento documento) {
		return documentoRepository.save(documento);
	}
	
	public Documento buscarDocumentoID(Integer id) {
		Optional<Documento> documento = documentoRepository.findById(id);
		return documento.orElseThrow(() -> new ObjectNotFoundException(new Documento(), "Documento não encontrado. Id: "+id));
	}
	
	public Documento salvarAlteracao(Documento documentoAlterado) throws ObjectNotFoundException {
		Documento documento = buscarDocumentoID(documentoAlterado.getId());
		documento.setId(documentoAlterado.getId());
		documento.setNome(documentoAlterado.getNome());
		documento.setCodigo(documento.getCodigo());
		return salvar(documento);
	}
	
	public void excluir(Integer id) {
		documentoRepository.deleteById(id);	
	}

}
