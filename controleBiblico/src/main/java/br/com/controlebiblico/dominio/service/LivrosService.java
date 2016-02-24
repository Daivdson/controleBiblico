package br.com.controlebiblico.dominio.service;

import java.util.List;

import br.com.controlebiblico.dominio.entidade.Livros;
import br.com.controlebiblico.dominio.repositorios.LivrosRepositorio;

public class LivrosService {
	private final LivrosRepositorio repo = new LivrosRepositorio();
	
	public Livros buscarPorId(final Long id){
		return repo.buscarPorId(id);
	}
	
	public Livros buscarPorLivro(String livro){
		return repo.buscarPorLivro(livro);
	}
	
	public List<Livros> buscarTodos(){
		return repo.buscarTodos();
	}
	
	public void excluir(Livros livros){
		repo.excluir(livros);
	}
	
	public Livros salvarOuAtualizar(Livros livros){
		return repo.salvarOuAtualizar(livros);
	}
}
