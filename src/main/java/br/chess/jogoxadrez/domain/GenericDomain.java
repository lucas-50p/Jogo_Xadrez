package br.chess.jogoxadrez.domain;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@SuppressWarnings("serial")
@MappedSuperclass//Ela vai ser usada por outras,herança
public class GenericDomain implements Serializable{

	
	@Id//chave primaria
	@GeneratedValue(strategy = GenerationType.AUTO)//propriedades, Indentity(quando o cara vai digitar);auto(o banco vai gerenciar)
	private Long codigo;
	
	public Long getCodigo() {
		return codigo;
	}
	
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
}
