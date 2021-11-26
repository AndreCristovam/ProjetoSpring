package br.com.primeiroprojetospring.domain;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Aluno implements Serializable {
	
	// primeira camada do MVC -  implementar as entidades
	
	/**
	 * Cria um endereço para localizar a serialização - para que nenhum dado se perda com o tempo
	 */
	private static final long serialVersionUID = -886604392341594251L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	
	
}
