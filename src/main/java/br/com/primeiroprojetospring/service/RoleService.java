package br.com.primeiroprojetospring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.primeiroprojetospring.domain.Role;
import br.com.primeiroprojetospring.repository.RoleRepository;

@Service
public class RoleService {
	
	@Autowired
	private RoleRepository roleRepository;
	
	public Role salvar(Role role) {
		return roleRepository.save(role);
	}

}
