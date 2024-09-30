package appbd.daoAtiv;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import appbd.daoAtiv.Emprestimo;

public interface DAO<T> {
	default public EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("emprestimoPersistence");
		EntityManager entityManager = factory.createEntityManager();
		return entityManager;
	}

	T findById(long id);
	List<T> findAll();
	void insert(T t);
	void update(T t);
	void delete(T t);
}