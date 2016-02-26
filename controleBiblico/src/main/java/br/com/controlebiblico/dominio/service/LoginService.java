package br.com.controlebiblico.dominio.service;

import java.util.List;

import br.com.controlebiblico.dominio.entidade.Login;
import br.com.controlebiblico.dominio.repositorios.LoginRepositorio;

public class LoginService {
	private final LoginRepositorio repo = new LoginRepositorio();
	
	public Login buscarPorId(final Long id){
		return repo.buscarPorId(id);
	}
	
	public Login buscarPorLoginESenha(String login, String senha){
		return repo.buscarPorLoginESenha(login, senha);
	}
	
	public List<Login> buscarTodos(){
		return repo.buscarTodos();
	}
	
	public void excluir(Login login){
		repo.excluir(login);
	}
	
	public Login salvarOuAtualizar(Login login){
		return repo.salvarOuAtualizar(login);
	}
}
