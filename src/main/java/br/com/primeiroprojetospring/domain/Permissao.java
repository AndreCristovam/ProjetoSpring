package br.com.primeiroprojetospring.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;

import lombok.Data;

@Data
@Entity
public class Permissao implements GrantedAuthority {
	
	private static final long serialVersionUID = -5085839126693531524L;

	public static final String INSERT = "insert";

	@Id
	private String nomePermissao;
	
	@ManyToMany(mappedBy = "permissoes")
	private List<Usuario> usuarios;
	
	@Override
	public String getAuthority() {
		return this.nomePermissao;
	}

}
