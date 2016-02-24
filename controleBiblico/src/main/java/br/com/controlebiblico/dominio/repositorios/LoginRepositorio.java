package br.com.controlebiblico.dominio.repositorios;

import java.util.List;

import javax.persistence.EntityManager;

import org.h2.command.ddl.AlterUser;

import br.com.controlebiblico.dominio.entidade.Login;
import br.com.controlebiblico.infraestrutura.persistencia.dao.impl.LoginDAO;
import br.com.controlebiblico.infraestrutura.persistencia.util.JPAUtil;

public class LoginRepositorio {
	private EntityManager em;
	private LoginDAO DAO;
	
	private void criarDAOeEM(){
		em = JPAUtil.getEntityManager();
		DAO = new LoginDAO(em);
	}
	
	public Login buscarPorId(Long id){
		criarDAOeEM();
		Login l = DAO.buscarPorId(id);
		em.close();
		return l;
	}
	
	public List<Login> buscarTodos(){
		criarDAOeEM();
		List<Login> lista = DAO.buscarTodos();
		em.close();
		return lista;
	}
	
	public void excluir(final Login login){
		criarDAOeEM();
		em.getTransaction().begin();
		try{
			DAO.excluir(login);
			em.getTransaction().commit();
		}catch (final Exception e){
			em.getTransaction().rollback();
		}
		em.close();
	}
	
	public Login salvarOuAtualizar(Login login){
		criarDAOeEM();
		em.getTransaction().begin();
		try{
			login = DAO.salvarOuAtualizar(login);
			em.getTransaction().commit();
		}catch (Exception e){
			em.getTransaction().rollback();
			throw e;
		}finally{
			em.close();
		}
		return login;
	}
	
	public Login buscarPorLoginESenha(String login, String senha){
		criarDAOeEM();
		Login l = DAO.bucarPorLoginESenha(login, senha);
		em.close();
		return l;
	}

}
