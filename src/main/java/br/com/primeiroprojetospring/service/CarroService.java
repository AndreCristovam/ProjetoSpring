package br.com.primeiroprojetospring.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.querydsl.jpa.impl.JPAQueryFactory;

import br.com.primeiroprojetospring.domain.Carro;
import br.com.primeiroprojetospring.domain.Documento;
import br.com.primeiroprojetospring.domain.Fabricante;
import br.com.primeiroprojetospring.domain.QCarro;
import br.com.primeiroprojetospring.domain.QDocumento;
import br.com.primeiroprojetospring.domain.QFabricante;
import br.com.primeiroprojetospring.repository.CarroRepository;

@Service
public class CarroService {

	@Autowired
	private CarroRepository carroRepository;

	@Autowired
	private EntityManager entityManager;

	public List<Carro> buscarTodosCarros() {
		return carroRepository.findAll();
	}

	public Carro salvar(Carro carro) {
		return carroRepository.save(carro);
	}

	public Carro buscarCarroID(Integer id) {
		Optional<Carro> carro = carroRepository.findById(id);
		return carro.orElseThrow(() -> new ObjectNotFoundException(new Carro(), "Carro não encontrado. Id: " + id));
	}

	public Carro salvarAlteracao(Carro carroAlterado) throws ObjectNotFoundException {
		Carro carro = buscarCarroID(carroAlterado.getId());
		carro.setId(carroAlterado.getId());
		carro.setModelo(carroAlterado.getModelo());
		carro.setChaveCarro(carroAlterado.getChaveCarro());
		carro.setDocumentoCarro(carroAlterado.getDocumentoCarro());
		carro.setAcessorios(carroAlterado.getAcessorios());
		carro.setFabricanteCarro(carroAlterado.getFabricanteCarro());
		return salvar(carro);
	}

	public void excluir(Integer id) {
		carroRepository.deleteById(id);
	}

	public List<Carro> findCarroforIdFabricante(Fabricante id) {

		QFabricante fabricante = QFabricante.fabricante;
		QCarro carro = QCarro.carro;

		return new JPAQueryFactory(entityManager).selectFrom(carro)
				.innerJoin(carro.fabricanteCarro, fabricante)
				.where(carro.fabricanteCarro.eq(id)).fetch();
	}

	public List<Carro> findCarroforIdDocumento(Documento id) {

		QDocumento documento = QDocumento.documento;
		QCarro carro = QCarro.carro;

		return new JPAQueryFactory(entityManager).selectFrom(carro)
				.innerJoin(carro.documentoCarro, documento)
				.where(carro.documentoCarro.eq(id)).fetch();
	}

}
