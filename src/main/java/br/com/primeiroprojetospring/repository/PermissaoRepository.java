package br.com.primeiroprojetospring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.primeiroprojetospring.domain.Permissao;

@Repository
public interface PermissaoRepository extends CrudRepository<Permissao, String> {

}
