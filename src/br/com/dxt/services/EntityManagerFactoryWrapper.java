package br.com.dxt.services;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactoryWrapper {

	private static final EntityManagerFactory emf;
	
	static {
		emf = Persistence.createEntityManagerFactory("my-pu");
	}
	
	public static EntityManagerFactory getEntityManagerFactory() {
		return emf;
	}
	
}
