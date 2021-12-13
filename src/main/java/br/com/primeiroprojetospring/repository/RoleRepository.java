package br.com.primeiroprojetospring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.primeiroprojetospring.domain.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, String> {

}
