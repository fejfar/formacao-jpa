package br.com.dxt.services;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.dxt.domain.MyAbstractEntity;

public class AbstractService<T> {

	private Class<T> clazz;

	public AbstractService(Class<T> clazz) {
		super();
		this.clazz = clazz;
	}

	protected EntityManager getEm() {
		EntityManagerFactory emf = EntityManagerFactoryWrapper.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		return em;
	}

	public T buscarPorId(Object id) {
		return getEm().find(clazz, id);
	}

	public List<T> buscarTodos() {
		String jpql = "FROM " + clazz.getSimpleName() + " t";
		TypedQuery<T> qry = getEm().createQuery(jpql, clazz);
		try {
			return qry.getResultList();
		} catch (NoResultException e) {
			return Collections.emptyList();
		}
	}

	public List<T> buscarPorFiltroSimplesIgual(String field, Object value) {
		String jpql = "FROM " + clazz.getSimpleName() + " t WHERE t." + field + " = :value";
		TypedQuery<T> qry = getEm().createQuery(jpql, clazz);
		qry.setParameter("value", value);
		try {
			return qry.getResultList();
		} catch (NoResultException e) {
			return Collections.emptyList();
		}
	}

	public <E extends MyAbstractEntity> E salvar(E entity) {
		EntityManager em = getEm();

		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			if (entity.id == null) {
				em.persist(entity);
			} else {
				return em.merge(entity);
			}
			transaction.commit();
		} finally {
			em.close();
		}
		return entity;
	}

	public <E extends MyAbstractEntity> E remove(E entity) {
		EntityManager em = getEm();

		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			em.remove(entity);
			transaction.commit();
		} finally {
			em.close();
		}
		return entity;
	}
}