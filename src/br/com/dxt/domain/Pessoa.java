package br.com.dxt.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@MappedSuperclass
public abstract class Pessoa extends MyAbstractEntity {

	@Column
	public String nome;

	@OneToOne(cascade=CascadeType.PERSIST)
	public Endereco endereco;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "pessoa_id")
	public List<Telefone> telefones;

}
