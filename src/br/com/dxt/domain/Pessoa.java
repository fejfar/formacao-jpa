package br.com.dxt.domain;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Pessoa extends MyAbstractEntity {

	@Column
	public String nome;

}
