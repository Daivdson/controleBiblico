package br.com.controlebiblico.infraestrutura.persistencia.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.controlebiblico.dominio.entidade.Livros;
import br.com.controlebiblico.infraestrutura.persistencia.dao.GenericDAO;

public class LivrosDAO {
	private final GenericDAO<Livros, Long> DAO;
	
	public LivrosDAO (EntityManager entityManager){
		DAO = new GenericDAOHibernate<>(entityManager, Livros.class);
	}
	
	public void excluir(Livros entidade){
		DAO.excluir(entidade);
	}
	
	public Livros salvarOuAtualizar(Livros entidade){
		return DAO.salvarOuAtualizar(entidade);
	}
	
	public Livros buscarPorId(Long id){
		return DAO.buscarPorId(id);
	}
	
	public List<Livros> buscarTodos(){
		return DAO.buscarTodos();
	}
	
	public Livros buscarPorNomeLivro(String nomeLivro){
		Livros exemplo = new Livros();
		exemplo.setNomeLivro(nomeLivro);
		List<Livros> porExemplo = DAO.buscaPorExemplo(exemplo);
		if(porExemplo != null && !porExemplo.isEmpty()){
			return porExemplo.get(0);
		}else{
			return null;
		}
	}
	

}
