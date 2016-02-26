package br.com.controlebiblico.dominio.repositorios;

import java.util.List;

import javax.persistence.EntityManager;

import org.h2.command.ddl.AlterUser;

import br.com.controlebiblico.dominio.entidade.Usuario;
import br.com.controlebiblico.infraestrutura.persistencia.dao.impl.LoginDAO;
import br.com.controlebiblico.infraestrutura.persistencia.util.JPAUtil;

public class LoginRepositorio {
	private EntityManager em;
	private LoginDAO DAO;
	
	private void criarDAOeEM(){
		em = JPAUtil.getEntityManager();
		DAO = new LoginDAO(em);
	}
	
	public Usuario buscarPorId(Long id){
		criarDAOeEM();
		Usuario l = DAO.buscarPorId(id);
		em.close();
		return l;
	}
	
	public List<Usuario> buscarTodos(){
		criarDAOeEM();
		List<Usuario> lista = DAO.buscarTodos();
		em.close();
		return lista;
	}
	
	public void excluir(final Usuario login){
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
	
	public Usuario salvarOuAtualizar(Usuario login){
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
	
	public Usuario buscarPorLoginESenha(String login, String senha){
		criarDAOeEM();
		Usuario l = DAO.bucarPorLoginESenha(login, senha);
		em.close();
		return l;
	}

}
