package br.com.dxt.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;


@MappedSuperclass
public abstract class Pessoa extends MyAbstractEntity {

	@Column
	public String nome;
	
	@OneToOne(cascade=CascadeType.ALL)
	public Endereco endereco;

}
