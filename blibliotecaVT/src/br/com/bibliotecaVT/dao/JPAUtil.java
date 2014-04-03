package br.com.bibliotecaVT.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class JPAUtil {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("bibliotecavt");

	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
}
