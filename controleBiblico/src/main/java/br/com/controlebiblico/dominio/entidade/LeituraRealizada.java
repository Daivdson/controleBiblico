package br.com.controlebiblico.dominio.entidade;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
//@Table (name ="tb_leitura_realizada")
public class LeituraRealizada {
	@Id
	@GeneratedValue
	//@Column (name = "021_id")
	private Long idLeituraRealizada;
	
	//@Column (name = "022_id_usuario")
	@ManyToOne //relacionamento das tabelas de :: MUITOS PARA UM
	private Login login;
	
	//@Column (name = "023_id_livro")
	@ManyToMany //relacionameno das tabelas de:: MUITOS PARA MUITOS
	private List<Livros> livros;
	
	//@Column (name = "024_capitulo")
	private int capitulo;
	
	//@Column (name = "025_versiculo")
	private int versiculo;
	
	//@Column (name ="026_data")
	@Temporal (TemporalType.TIMESTAMP)
	private Calendar data;

	
	
	public Long getIdLeituraRealizada() {
		return idLeituraRealizada;
	}

	public void setIdLeituraRealizada(Long idLeituraRealizada) {
		this.idLeituraRealizada = idLeituraRealizada;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public List<Livros> getLivros() {
		return livros;
	}

	public void setLivros(List<Livros> livros) {
		this.livros = livros;
	}

	public int getCapitulo() {
		return capitulo;
	}

	public void setCapitulo(int capitulo) {
		this.capitulo = capitulo;
	}

	public int getVersiculo() {
		return versiculo;
	}

	public void setVersiculo(int versiculo) {
		this.versiculo = versiculo;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	

}
