package br.com.primeiroprojetospring.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.primeiroprojetospring.domain.Chave;
import br.com.primeiroprojetospring.repository.ChaveRepository;

@Service
public class ChaveService {

	@Autowired
	private ChaveRepository chaveRepository;
	
	public List<Chave> buscarTodasChaves() {
		return chaveRepository.findAll();
	}
	
	public Chave salvar(Chave chave) {
		return chaveRepository.save(chave);
	}
	
	public Chave buscarChaveID(Integer id) {
		Optional<Chave> chave = chaveRepository.findById(id);
		return chave.orElseThrow(() -> new ObjectNotFoundException(new Chave(), "Chave não encontrada. Id: "+id));
	}
	
	public Chave salvarAlteracao(Chave chaveAlterada) throws ObjectNotFoundException {
		Chave chave = buscarChaveID(chaveAlterada.getId());
		chave.setId(chaveAlterada.getId());
		chave.setCodigo(chaveAlterada.getCodigo());
		return salvar(chave);
	}
	
	public void excluir(Integer id) {
		chaveRepository.deleteById(id);	
	}
}
