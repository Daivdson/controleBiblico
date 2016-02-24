package br.com.controlebiblico.dominio.repositorios;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.controlebiblico.dominio.entidade.Livros;
import br.com.controlebiblico.infraestrutura.persistencia.dao.impl.LivrosDAO;
import br.com.controlebiblico.infraestrutura.persistencia.util.JPAUtil;

public class LivrosRepositorio {
	private EntityManager em;
	private LivrosDAO DAO;
	
	private void criarDAOeEM(){
		em = JPAUtil.getEntityManager();
		DAO = new LivrosDAO(em);
	}
	
	public Livros buscarPorId(Long id){
		criarDAOeEM();
		Livros l = DAO.buscarPorId(id);
		em.close();
		return l;
	}
	
	public List<Livros> buscarTodos(){
		criarDAOeEM();
		List<Livros> lista = DAO.buscarTodos();
		em.close();
		return lista;
	}
	
	public void excluir(final Livros livro){
		criarDAOeEM();
		em.getTransaction().begin();
		try{
			DAO.excluir(livro);
			em.getTransaction().commit();
		}catch(final Exception e){
			em.getTransaction().rollback();
		}
		em.close();
	}
	
	public Livros salvarOuAtualizar(Livros livro){
		criarDAOeEM();
		em.getTransaction().begin();
		
		try{
			livro = DAO.salvarOuAtualizar(livro);
			em.getTransaction().commit();
		}catch(Exception e){
			em.getTransaction().rollback();
			throw e;
		}finally{
			em.close();
		}
		return livro;
	}
	
	public Livros buscarPorLivro(String livro){
		criarDAOeEM();
		Livros l = DAO.buscarPorNomeLivro(livro);
		em.close();
		return l;
	}

}
