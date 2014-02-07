package br.com.dxt.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;

@MappedSuperclass
public abstract class MyAbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GERAL_SEQ")
	@SequenceGenerator(name = "GERAL_SEQ", sequenceName = "geral_seq", allocationSize = 1)
	public Long id;

}