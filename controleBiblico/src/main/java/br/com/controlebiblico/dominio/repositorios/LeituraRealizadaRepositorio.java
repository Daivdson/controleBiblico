package br.com.controlebiblico.dominio.repositorios;

import java.util.List;

import javax.persistence.EntityManager;

import org.h2.command.ddl.AlterUser;
import org.hibernate.jpa.criteria.compile.CriteriaQueryTypeQueryAdapter;

import br.com.controlebiblico.dominio.entidade.LeituraRealizada;
import br.com.controlebiblico.infraestrutura.persistencia.dao.impl.LeituraRealizadaDAO;
import br.com.controlebiblico.infraestrutura.persistencia.util.JPAUtil;

public class LeituraRealizadaRepositorio {
	private EntityManager em;
	private LeituraRealizadaDAO DAO;
	
	private void criarDAOeEM(){
		em = JPAUtil.getEntityManager();
		DAO = new LeituraRealizadaDAO(em);
	}
	
	public LeituraRealizada buscarPorId(Long id){
		criarDAOeEM();
		LeituraRealizada l = DAO.buscarPorId(id);
		em.close();
		return l;
	}
	
	public List<LeituraRealizada> buscarTodos(){
		criarDAOeEM();
		List<LeituraRealizada> lista = DAO.buscarTodos();
		em.close();
		return lista;
	}
	
	public void excluir(final LeituraRealizada leituraRealizada){
		criarDAOeEM();
		em.getTransaction().begin();
		try{
			DAO.excluir(leituraRealizada);
			em.getTransaction().commit();
		}catch(final Exception e){
			em.getTransaction().rollback();
		}
		em.close();
	}
	
	public LeituraRealizada salvarOuAtualizar(LeituraRealizada leituraRealizada){
		criarDAOeEM();
		em.getTransaction().begin();
		try {
			leituraRealizada = DAO.salvarOuAtualizar(leituraRealizada);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw e;
		}finally{
			em.close();
		}
		return leituraRealizada;
	}
	

}
