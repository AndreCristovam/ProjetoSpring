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
public class Fabricante implements Serializable {
	

	private static final long serialVersionUID = 5886410820555858910L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	

	@Column(name="NOME_FABRICANTE")
	private String nome;
	
	@Column(name="PAIS_FABRICANTE")
	private String pais;

}
