package br.com.controlebiblico.infraestrutura.persistencia.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.controlebiblico.dominio.entidade.LeituraRealizada;
import br.com.controlebiblico.infraestrutura.persistencia.dao.GenericDAO;

public class LeituraRealizadaDAO {
	private final GenericDAO<LeituraRealizada, Long> DAO;
	
	public LeituraRealizadaDAO (EntityManager entityManager){
		DAO = new GenericDAOHibernate<>(entityManager, LeituraRealizada.class);
	}
	
	public void excluir(LeituraRealizada entidade){
		DAO.excluir(entidade);
	}

	public LeituraRealizada buscarPorId(Long id){
		return DAO.buscarPorId(id);
	}
	
	public List<LeituraRealizada> buscarTodos(){
		return DAO.buscarTodos();
	}
	public LeituraRealizada salvarOuAtualizar(LeituraRealizada entidade){
		return DAO.salvarOuAtualizar(entidade);
	}
	
}
