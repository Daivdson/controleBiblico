package br.com.controlebiblico.infraestrutura.persistencia.dao.impl;

import br.com.controlebiblico.infraestrutura.persistencia.dao.GenericDAO;
import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;



public class GenericDAOHibernate <T, ID extends Serializable> implements GenericDAO<T, ID> {
	private final Class<T> CLASSE;
	private final EntityManager ENTITY_MANAGER;
	
	public GenericDAOHibernate(final EntityManager entityManager, final Class<T> Classe){
		ENTITY_MANAGER = entityManager;
		CLASSE = Classe;
	}

	@Override
	public T salvarOuAtualizar(T entidade) {
		return ENTITY_MANAGER.merge(entidade);
	}

	@Override
	public T buscarPorId(ID id) {
		return ENTITY_MANAGER.find(CLASSE, id);
	}

	@Override
	public List<T> buscarTodos() {
		final CriteriaQuery<T> query = ENTITY_MANAGER.getCriteriaBuilder().createQuery(CLASSE);
		query.select(query.from(CLASSE));
		return ENTITY_MANAGER.createQuery(query).getResultList();
	}

	@Override
	public void excluir(T entidade) {
		entidade = ENTITY_MANAGER.merge(entidade);
		ENTITY_MANAGER.remove(entidade);
		
	}

	private Session getHibernateSession(){
		final Session session = (Session) ENTITY_MANAGER.getDelegate();
		return session;
	}
	
	@Override
	public List<T> buscarPorCriteria(Criterion... criteria) {
		final Session session = getHibernateSession();
		final Criteria crit = session.createCriteria(CLASSE);
		for(Criterion criterion : criteria){
			crit.add(criterion);
		}
		return crit.list();
	}
	
	

	@Override
	public List<T> buscaPorExemplo(T exemplo, String... PropriedadesAExcluir) {

		final Example exemple = Example.create(exemplo);
		
		exemple.enableLike(MatchMode.ANYWHERE);
		exemple.excludeZeroes();
		exemple.ignoreCase();
		
		for(String prop : PropriedadesAExcluir){
			exemple.excludeProperty(prop);
		}
		
		final Session session = getHibernateSession();
		final Criteria criteria = session.createCriteria(CLASSE).add(exemple);
		return criteria.list();
	}
	
	

}
