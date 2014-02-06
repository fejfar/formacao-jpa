package br.com.dxt.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class PessoaJuridica extends Pessoa {

	@Column(nullable=false)
	public String cpnj;
	
}
