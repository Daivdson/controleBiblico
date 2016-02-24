package br.com.controlebiblico.infraestrutura.persistencia.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.controlebiblico.dominio.entidade.Login;
import br.com.controlebiblico.infraestrutura.persistencia.dao.GenericDAO;

public class LoginDAO {
	private final GenericDAO<Login, Long> DAO;
	
	public LoginDAO(EntityManager entityManager){
		DAO = new GenericDAOHibernate<>(entityManager, Login.class);
	}
	
	public Login buscarPorId(Long id){
		return DAO.buscarPorId(id);
	}
	
	public Login bucarPorLoginESenha(String login, String senha){
		Login exemplo = new Login();
		exemplo.setLogin(login);
		exemplo.setSenha(senha);
		
		List<Login> list = DAO.buscaPorExemplo(exemplo);
		if(list != null && !list.isEmpty()){
			return list.get(0);
		}else{
			return null;
		}
	}
	
	public List<Login> buscarTodos(){
		return DAO.buscarTodos();
	}
	
	public void excluir(Login login){
		DAO.excluir(login);
	}
	
	public Login salvarOuAtualizar(Login login){
		return DAO.salvarOuAtualizar(login);
	}

}
