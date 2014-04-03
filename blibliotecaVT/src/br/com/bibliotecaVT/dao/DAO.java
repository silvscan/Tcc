package br.com.bibliotecaVT.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

import br.com.bibliotecaVT.modelo.Trabalho;

public class DAO<T> {
	private final Class<T> classe;

	public DAO(Class<T> classe) {
		this.classe = classe;
	}

	public void adiciona(T t) throws Exception{
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
		em.close();
	}

	public void remove(T t) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();

		em.remove(em.merge(t));

		em.getTransaction().commit();
		em.close();
	}

	public void atualiza(T t) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();

		em.merge(t);

		em.getTransaction().commit();
		em.close();
	}

	public List<T> listaTodos() {
		EntityManager em = new JPAUtil().getEntityManager();
		CriteriaQuery<T> query = em.getCriteriaBuilder().createQuery(classe);
		query.select(query.from(classe));

		List<T> lista = em.createQuery(query).getResultList();

		em.close();
		return lista;
	}
	
	public T buscaPorId(Long id) {
		EntityManager em = new JPAUtil().getEntityManager();
		T instancia = em.find(classe, id);
		
		em.close();
		return instancia;
	}
	
	public T buscaPorCPF(Long cpf) {
		EntityManager em = new JPAUtil().getEntityManager();
		T instancia = em.find(classe, cpf);
		
		em.close();
		return instancia;
	}
	
	public int contaTodos() {
		EntityManager em = new JPAUtil().getEntityManager();
		long result = (Long) em.createQuery("select count(n) from " + classe.getName() + " n").getSingleResult();
		
		em.close();
		return (int) result;
	}

	public List<T> listaTodosPaginada(int firstResult, int maxResults) {
		EntityManager em = new JPAUtil().getEntityManager();
		CriteriaQuery<T> query = em.getCriteriaBuilder().createQuery(classe);
		query.select(query.from(classe));

		List<T> lista = em.createQuery(query).setFirstResult(firstResult)
				.setMaxResults(maxResults).getResultList();

		em.close();
		return lista;
	}

//	@SuppressWarnings("unchecked")
//	public List<Trabalho> listaTrabalhosPagComFiltro(long raAluno, long codOrientador, long codCurso, long idAConhecimento, int firstResult, int maxResults) {
//		EntityManager em = new JPAUtil().getEntityManager();
//		
//		Query query = 
//				em.createQuery("select tb from Trabalho tb where "
//				+ "tb.aluno.ra = :raAluno"
//				);
//		
//		query.setParameter("raAluno", raAluno);
//		List<Trabalho> list = (List<Trabalho>) query.setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
//		return list;
//	}

	@SuppressWarnings("unchecked")
	public List<Trabalho> listaTrabalhosPagComFiltro(String preQuery, int firstResult, int maxResults) {
		EntityManager em = new JPAUtil().getEntityManager();
		Query query = em.createQuery(preQuery);
		List<Trabalho> list = (List<Trabalho>) query.setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
		return list;
	}


}
