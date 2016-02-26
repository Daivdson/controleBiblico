package br.com.controlebiblico.aplicacao.managedbeans;

import java.util.Collection;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.controlebiblico.dominio.entidade.Usuario;
import br.com.controlebiblico.dominio.service.LoginService;

@ViewScoped
@ManagedBean
public class LoginBean {
	private Usuario usuario = new Usuario();
	
	private Collection<Usuario> usuarios;
	// criando service para realizar operaçoes	
	private LoginService service = new LoginService();
	
	public void gravar(){
		System.out.println("Login aqui"+usuario);
		service.salvarOuAtualizar(usuario);
		limpar();
		
	}


	public void limpar(){
		usuario = new Usuario();
	}


	
	
	// metos acessadores
	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
