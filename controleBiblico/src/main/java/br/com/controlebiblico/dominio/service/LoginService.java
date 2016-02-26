package br.com.controlebiblico.dominio.service;

import java.util.List;

import br.com.controlebiblico.dominio.entidade.Usuario;
import br.com.controlebiblico.dominio.repositorios.LoginRepositorio;

public class LoginService {
	private final LoginRepositorio repo = new LoginRepositorio();
	
	public Usuario buscarPorId(final Long id){
		return repo.buscarPorId(id);
	}
	
	public Usuario buscarPorLoginESenha(String login, String senha){
		return repo.buscarPorLoginESenha(login, senha);
	}
	
	public List<Usuario> buscarTodos(){
		return repo.buscarTodos();
	}
	
	public void excluir(Usuario login){
		repo.excluir(login);
	}
	
	public Usuario salvarOuAtualizar(Usuario login){
		return repo.salvarOuAtualizar(login);
	}
}
