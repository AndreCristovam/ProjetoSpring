package br.com.primeiroprojetospring.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.querydsl.jpa.impl.JPAQueryFactory;

import br.com.primeiroprojetospring.domain.Fabricante;
import br.com.primeiroprojetospring.domain.QFabricante;
import br.com.primeiroprojetospring.repository.FabricanteRepository;

@Service
public class FabricanteService {
	
	@Autowired
	private FabricanteRepository fabricanteRepository;
	
	@Autowired
	private EntityManager entityManager;
	
	public List<Fabricante> buscarTodosFabricantes() {
		return fabricanteRepository.findAll();
	}
	
	public Fabricante salvar(Fabricante fabricante) {
		return fabricanteRepository.save(fabricante);
	}
	
	public Fabricante buscarFabricanteID(Integer id) {
		Optional<Fabricante> fabricante = fabricanteRepository.findById(id);
		return fabricante.orElseThrow(() -> new ObjectNotFoundException(new Fabricante(), "Fabricante não encontrado. Id: "+id));
	}
	
	public Fabricante salvarAlteracao(Fabricante fabricanteAlterado) throws ObjectNotFoundException {
		Fabricante fabricante = buscarFabricanteID(fabricanteAlterado.getId());
		fabricante.setId(fabricanteAlterado.getId());
		fabricante.setNome(fabricanteAlterado.getNome());
		fabricante.setPais(fabricanteAlterado.getPais());
		return salvar(fabricante);
	}
	
	public void excluir(Integer id) {
		fabricanteRepository.deleteById(id);	
	}
	
	public List<Fabricante> findFabricanteForPais(String pais){
		QFabricante fabricante = QFabricante.fabricante;
		
		return new JPAQueryFactory(entityManager).selectFrom(fabricante)
				.where(fabricante.pais.eq(pais)).fetch();
	}

}
