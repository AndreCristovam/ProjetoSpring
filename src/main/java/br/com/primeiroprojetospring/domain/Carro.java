package br.com.primeiroprojetospring.domain;


import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Carro implements Serializable {
	
	private static final long serialVersionUID = 1864937557027431368L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String modelo;
	
	@OneToOne
	@JoinColumn(name="ID_CHAVE")
	private Chave chaveCarro;
	
	@OneToOne
	@JoinColumn(name="ID_DOCUMENTO")
	private Documento documentoCarro;
	
	@ManyToMany
	@JoinTable(name="REL_CARRO_ACESSORIO",
		joinColumns = {@JoinColumn(name="ID_CARRO")},
		inverseJoinColumns = {@JoinColumn(name="ID_ACESSORIO")})	
	private List<Acessorio> acessorios;
	
	@ManyToOne
	@JoinColumn(name="ID_FABRICANTE")
	private Fabricante fabricanteCarro;

	
}
