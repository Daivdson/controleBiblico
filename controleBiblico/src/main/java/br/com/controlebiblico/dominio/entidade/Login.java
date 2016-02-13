package br.com.controlebiblico.dominio.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
//@Table(name = "tb_login")
public class Login{
	
	@Id
	@GeneratedValue
	//@Column(name = "001_id")
	private Long idLogin;
	
	//@Column(name = "002nome")
	private String nomeLogin;
	
	//@Column (name = "003_login")
	private String Login;
	
	//@Column (name = "004_senha")
	private String senha;
	
	public long getIdLogin() {
		return idLogin;
	}
	public void setIdLogin(long idLogin) {
		this.idLogin = idLogin;
	}
	public String getNomeLogin() {
		return nomeLogin;
	}
	public void setNomeLogin(String nomeLogin) {
		this.nomeLogin = nomeLogin;
	}
	public String getLogin() {
		return Login;
	}
	public void setLogin(String login) {
		Login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	

}
