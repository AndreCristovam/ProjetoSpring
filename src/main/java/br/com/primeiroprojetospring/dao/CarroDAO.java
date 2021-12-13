package br.com.primeiroprojetospring.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;

import br.com.primeiroprojetospring.domain.Carro;
import br.com.primeiroprojetospring.domain.QCarro;
import br.com.primeiroprojetospring.domain.QDocumento;
import br.com.primeiroprojetospring.domain.QFabricante;

@Repository
public class CarroDAO {

	@Autowired
	private EntityManager entityManager;
	
	
	private QCarro carro = QCarro.carro;
	
	private final String TETO_SOLAR = "Teto Solar";
		
	public List<Carro> findCarroforIdFabricante(Integer id) {

		QFabricante fabricante = QFabricante.fabricante;		

		return new JPAQueryFactory(entityManager).selectFrom(carro)
				.innerJoin(carro.fabricanteCarro, fabricante)
				.where(carro.fabricanteCarro.id.eq(id)).fetch();
	}

	public List<Carro> findCarroforIdDocumento(Integer id) {

		QDocumento documento = QDocumento.documento;
		
		return new JPAQueryFactory(entityManager).selectFrom(carro)
				.innerJoin(carro.documentoCarro, documento)
				.where(carro.documentoCarro.id.eq(id)).fetch();
	}
	
	public List<Carro> findCarroForTetoSolar(){	
		
		return new JPAQueryFactory(entityManager).selectFrom(carro)				
				.where(carro.acessorios.any().nome.equalsIgnoreCase(TETO_SOLAR)).fetch();
	}
}
	