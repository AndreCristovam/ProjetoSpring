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
public class Chave implements Serializable {

	private static final long serialVersionUID = 4492246752547242827L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="CODIGO_CHAVE")
	private String codigo;

	
}
