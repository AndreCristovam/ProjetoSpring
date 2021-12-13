package br.com.primeiroprojetospring.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Usuario implements UserDetails, Serializable{

	private static final long serialVersionUID = -2476514583695693809L;		


	@Id
	@Setter
	private String login;
	
	@Setter
    private String password;
    
    @Setter
    @Getter
    private String nomeCompleto;
    
    @ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="REL_USUARIO_ROLES",
		joinColumns = {@JoinColumn(name="LOGIN")},
		inverseJoinColumns = {@JoinColumn(name="NOME_ROLE")})	
    @Getter
    @Setter
	private List<Role> roles;
    
    @ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "REL_USUARIO_PERMISSAO",
		joinColumns = { @JoinColumn(name = "LOGIN") }, inverseJoinColumns = {
		@JoinColumn(name = "NOME_PERMISSAO") })
	@Getter
	@Setter
	private List<Permissao> permissoes;
    
    
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {		
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		this.permissoes.stream().forEach(perm -> {
			GrantedAuthority authority = 
					new SimpleGrantedAuthority(perm.getNomePermissao());
			authorities.add(authority);
		});
		
		this.roles.stream().forEach(role -> {
			GrantedAuthority authority = 
					new SimpleGrantedAuthority(role.getNomeRole());
			authorities.add(authority);
		});
		return authorities;
	}

	@Override
	public String getPassword() {		
		return this.password;
	}

	@Override
	public String getUsername() {		
		return this.nomeCompleto;
	}

	@Override
	public boolean isAccountNonExpired() {		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {		
		return true;
	}

	@Override
	public boolean isEnabled() {	
		return true;
	}

}
