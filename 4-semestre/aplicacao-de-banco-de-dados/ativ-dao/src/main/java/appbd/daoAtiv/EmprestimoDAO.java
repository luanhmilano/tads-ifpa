/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appbd.daoAtiv;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;


public class EmprestimoDAO implements DAO<Emprestimo> {
	EntityManager em = getEntityManager();

	@Override
	public Emprestimo findById(long id) {
		return em.find(Emprestimo.class, id);
	}

	@Override
	public List<Emprestimo> findAll() {
		javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
		cq.select(cq.from(Emprestimo.class));
		return getEntityManager().createQuery(cq).getResultList();
	}

	@Override
	public void insert(Emprestimo t) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(t);
		transaction.commit();
	}

	@Override
	public void update(Emprestimo t) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.merge(t);
		transaction.commit();
	}

	@Override
	public void delete(Emprestimo t) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		Emprestimo emprestimo = em.find(Emprestimo.class, t.getIdEmprestimo());
		em.remove(emprestimo);
		transaction.commit();
	}

}