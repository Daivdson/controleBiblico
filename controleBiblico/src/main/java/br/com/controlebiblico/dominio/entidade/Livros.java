package br.com.controlebiblico.dominio.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Table (name = "tb_livros")
public class Livros {
	@Id
	@GeneratedValue
	//@Column (name = "011_id")
	private Long idLivro;
	
	//@Column (name = "012_nome")
	private String nomeLivro;
	
	//@Column (name = "013_tipo")
	private String tipo;
	
	//@Column (name = "014_qtd_capitulo")
	private int qtdCapitulos;
	
	//@Column (name = "015_qtd_versiculos")
	private int qtdVersiculos;
	
	//@Column (name ="016_descricao")
	private String descricaoLivro;
	
	
	
	

	public Long getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(Long idLivro) {
		this.idLivro = idLivro;
	}

	public String getNomeLivro() {
		return nomeLivro;
	}

	public void setNomeLivro(String nomeLivro) {
		this.nomeLivro = nomeLivro;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getQtdCapitulos() {
		return qtdCapitulos;
	}

	public void setQtdCapitulos(int qtdCapitulos) {
		this.qtdCapitulos = qtdCapitulos;
	}

	public int getQtdVersiculos() {
		return qtdVersiculos;
	}

	public void setQtdVersiculos(int qtdVersiculos) {
		this.qtdVersiculos = qtdVersiculos;
	}

	public String getDescricaoLivro() {
		return descricaoLivro;
	}

	public void setDescricaoLivro(String descricaoLivro) {
		this.descricaoLivro = descricaoLivro;
	}
	
	

}
