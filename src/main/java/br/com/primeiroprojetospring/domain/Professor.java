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
public class Professor implements Serializable{
	
	
	private static final long serialVersionUID = 215502318043377760L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="NOME_PROFESSOR")
	private String nome;

	
}
