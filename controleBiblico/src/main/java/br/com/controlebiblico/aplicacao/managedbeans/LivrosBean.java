package br.com.controlebiblico.aplicacao.managedbeans;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.controlebiblico.dominio.entidade.Livros;
import br.com.controlebiblico.dominio.service.LivrosService;

@ViewScoped
@ManagedBean
public class LivrosBean {
	private Livros livro = new Livros();
	private Collection<Livros> livros;
	
	private LivrosService service = new LivrosService();
	
	public void gravar(){
		System.out.println(getLivro());
		service.salvarOuAtualizar(getLivro());
		limpar();
	}
	
	public Collection<Livros> getLivrosL(){
		if(livros == null){
			livros = service.buscarTodos();
		}
		return livros;
	}
	
// montando lista de chebox dos livros
	private String[] numCapitulos;
	//Lista dos capitulos
	public String[] getNumCapitulosMat(){
		numCapitulos = new String[service.buscarPorLivro("Mateus").getQtdCapitulos()];
		for (int i = 1; service.buscarPorLivro("Mateus").getQtdCapitulos() >= i ; i++) {
			getNumCapitulos()[i] = Integer.toString(i);
		}
		return getNumCapitulos();
	}
	
	public String[] getNumCapitulosMar(){
		numCapitulos = new String[service.buscarPorLivro("Marcos").getQtdCapitulos()];
		for (int i = 1; service.buscarPorLivro("Marcos").getQtdCapitulos() >= i  ; i++) {
			getNumCapitulos()[i] = Integer.toString(i);
		}
		return getNumCapitulos();
	}
	

	public String getMeNumCapitulosInString(){
		return Arrays.toString(getNumCapitulos());
	}
	
	
	
	
	
	
	public void limpar(){
		livro = new Livros();
		
	}

	
	// metos acessadores
	public Livros getLivro() {
		return livro;
	}

	public void setLivro(Livros livro) {
		this.livro = livro;
	}

	public String[] getNumCapitulos() {
		return numCapitulos;
	}

	public void setNumCapitulos(String[] numCapitulos) {
		this.numCapitulos = numCapitulos;
	}


	
	

}
