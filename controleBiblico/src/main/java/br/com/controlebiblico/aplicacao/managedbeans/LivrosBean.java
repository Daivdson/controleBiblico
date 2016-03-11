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
		Arrays.fill(numCapitulos, null);
		numCapitulos = new String[service.buscarPorLivro("Mateus").getQtdCapitulos()];
		int contCapitulos = 0;
		int cap = 1;
		for (int i = 0; i < service.buscarPorLivro("Mateus").getQtdCapitulos() ; i++) {
			getNumCapitulos()[i] = Integer.toString(cap);
			contCapitulos = i;
			cap++;
		}
		System.out.println("quantidade de capitulos MATEUS: "+service.buscarPorLivro("Mateus").getQtdCapitulos());
		System.out.println("VALOR DO I CONTADOR: "+contCapitulos);
		return getNumCapitulos();
		
	}
	
	public String[] getNumCapitulosMar(){
		Arrays.fill(numCapitulos, null);
		
		numCapitulos = new String[service.buscarPorLivro("Marcos").getQtdCapitulos()];
		int cont2 = 0;
		int cap = 1;
		for (int i = 0 ; i < service.buscarPorLivro("Marcos").getQtdCapitulos()  ; i++) {
			getNumCapitulos()[i] = Integer.toString(cap);
			cont2 = i;
			cap++;
		}
		System.out.println("quantidade de capitulos MARCOS: "+service.buscarPorLivro("Marcos").getQtdCapitulos());
		System.out.println("VALOR DO I CONTADOR: "+cont2);
		return getNumCapitulos();
		
		
	}
	

	/*public String getMeNumCapitulosInString(){
		return Arrays.toString(getNumCapitulos());
	}*/
	
	
	
	
	
	
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
