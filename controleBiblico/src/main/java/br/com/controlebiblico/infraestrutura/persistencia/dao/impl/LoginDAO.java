package br.com.controlebiblico.infraestrutura.persistencia.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.controlebiblico.dominio.entidade.Usuario;
import br.com.controlebiblico.infraestrutura.persistencia.dao.GenericDAO;

public class LoginDAO {
	private final GenericDAO<Usuario, Long> DAO;
	
	public LoginDAO(EntityManager entityManager){
		DAO = new GenericDAOHibernate<>(entityManager, Usuario.class);
	}
	
	public Usuario buscarPorId(Long id){
		return DAO.buscarPorId(id);
	}
	
	public Usuario bucarPorLoginESenha(String login, String senha){
		Usuario exemplo = new Usuario();
		exemplo.setLogin(login);
		exemplo.setSenha(senha);
		
		List<Usuario> list = DAO.buscaPorExemplo(exemplo);
		if(list != null && !list.isEmpty()){
			return list.get(0);
		}else{
			return null;
		}
	}
	
	public List<Usuario> buscarTodos(){
		return DAO.buscarTodos();
	}
	
	public void excluir(Usuario login){
		DAO.excluir(login);
	}
	
	public Usuario salvarOuAtualizar(Usuario login){
		return DAO.salvarOuAtualizar(login);
	}

}
