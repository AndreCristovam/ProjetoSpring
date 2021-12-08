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
public class Acessorio implements Serializable {
	
	private static final long serialVersionUID = -6289229294210689983L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	

	@Column(name="NOME_ACESSORIO")
	private String nome;

		
}
