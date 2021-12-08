package br.com.primeiroprojetospring.domain;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Aluno implements Serializable {
	

	private static final long serialVersionUID = -886604392341594251L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	

	@Column(name="NOME_ALUNO")
	private String nome;

		
}
