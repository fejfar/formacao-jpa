package br.com.dxt.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.dxt.domain.PessoaFisica;

public class PessoaFisicaService extends AbstractService<PessoaFisica> {

	public PessoaFisicaService() {
		super(PessoaFisica.class);
	}

	public List<PessoaFisica> buscarPorNome(String nome) {
		EntityManager em = getEm();

		TypedQuery<PessoaFisica> query = em.createQuery(
				"FROM PessoaFisica p WHERE lower(p.nome) LIKE :paramNome",
				PessoaFisica.class);

		if (nome.indexOf('%') == -1) {
			nome = "%" + nome + "%";
		}

		query.setParameter("paramNome", nome.toLowerCase());

		try {
			return query.getResultList();
		} finally {
			em.close();
		}
	}

	public List<Object[]> buscarArrayPorNome(String nome) {
		EntityManager em = getEm();

		TypedQuery<Object[]> query = em
				.createQuery(
						"SELECT p.nome, p.id FROM PessoaFisica p WHERE lower(p.nome) LIKE :paramNome",
						Object[].class);

		if (nome.indexOf('%') == -1) {
			nome = "%" + nome + "%";
		}

		query.setParameter("paramNome", nome.toLowerCase());

		try {
			return query.getResultList();
		} finally {
			em.close();
		}
	}

	public List<String> buscarNomesPorNome(String nome) {
		EntityManager em = getEm();

		TypedQuery<String> query = em
				.createQuery(
						"SELECT p.nome FROM PessoaFisica p WHERE lower(p.nome) LIKE :paramNome",
						String.class);

		if (nome.indexOf('%') == -1) {
			nome = "%" + nome + "%";
		}

		query.setParameter("paramNome", nome.toLowerCase());

		try {
			return query.getResultList();
		} finally {
			em.close();
		}
	}

}
