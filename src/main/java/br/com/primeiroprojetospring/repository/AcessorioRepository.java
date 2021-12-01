package br.com.primeiroprojetospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.primeiroprojetospring.domain.Acessorio;

@Repository
public interface AcessorioRepository extends JpaRepository<Acessorio, Integer> {

}
