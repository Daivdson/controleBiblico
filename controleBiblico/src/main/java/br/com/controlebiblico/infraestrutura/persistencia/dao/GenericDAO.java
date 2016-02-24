package br.com.controlebiblico.infraestrutura.persistencia.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.Criterion;

public interface GenericDAO <T, ID extends Serializable>{
	
	// Salvar ou atualiza qualquer entidade
	T salvarOuAtualizar (T entidade);
	
	// Buscar por id
	T buscarPorId(ID id);
	
	// Busca todas as entidades
	List<T> buscarTodos();
	
	// Exclui a entidade
	void excluir(T entidade);
	
	// Recebe varias criterias e as utiliza para fazer uma pesquisa em banco
	// Retornando uma lista de entidades
	// (... = vararg)
	List<T> buscarPorCriteria(Criterion... criteria);
	
	// Retorna um conjunto de entidades que sejam parecidas com o exmplo.
	List<T> buscaPorExemplo(T exemplo, String... PropriedadesAExcluir);
	
	

}
