package br.com.controlebiblico.infraestrutura.persistencia;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Test;

import br.com.controlebiblico.dominio.entidade.LeituraRealizada;
import br.com.controlebiblico.dominio.entidade.Livros;
import br.com.controlebiblico.dominio.entidade.Login;
import javax.persistence.Query;


public class PersistenciaTesteBiblia {
	
	@Test
	//o que esta fazendo: 1ºcriando instacias de gerenciador de entidades / 2ºgerenciador de entidades 
	public void deveCriarOEntityManagerFactoryEEntityManager(){
		EntityManager em = JPAUtil.getEntityManager();
		em.close();
	}
	
		Calendar c = Calendar.getInstance();//pega a data atual

	@Test
	public void persistirUmUsuario(){
		EntityManager em = JPAUtil.getEntityManager();
		
		Login newUser = new Login();
		newUser.setLogin("admin");
		newUser.setNomeLogin("Administrador");
		newUser.setSenha("admin");
		em.getTransaction().begin();
		em.persist(newUser);
		em.getTransaction().commit();
		
		// VERIFICA SE OBJETO FOI CRIADO -- LISTANDO
		//HQL
		Query query = em.createQuery("SELECT l FROM Login l");
		List<Login> list = query.getResultList();
		
		for(Login l: list){
			System.out.println(l.getIdLogin()+"--"+l.getLogin()+"--"+l.getNomeLogin()+"--"+l.getSenha());
		}
		em.close();
		
	}
	
	/*
	 * 
	 // VERIFICA SE OBJETO FOI CRIADO -- LISTANDO
		//HQL
		Query  query = em.createQuery("SELECT a FROM Aluno a");
		List<Aluno> list = query.getResultList();
		
		for (Aluno a : list){
			System.out.println(a.getId()+"--"+a.getNomeCompleto()+"--"+ a.getEmail()+"--"+a.getRg());
		}

		
		em.close(); 
	 * 
	@Test
	public void persistirUmaLeitura(){
		EntityManager em = JPAUtil.getEntityManager();
		
		Login newUser = new Login();
		newUser.setLogin("admin");
		newUser.setNomeLogin("Administrador");
		newUser.setSenha("admin");
		em.getTransaction().begin();
		em.persist(newUser);
		em.getTransaction().commit();
		
		Livros newLivro = new Livros();
		newLivro.setDescricaoLivro("Evangelho de Mateus");
		newLivro.setNomeLivro("Mateus");
		newLivro.setQtdCapitulos(27);
		newLivro.setQtdVersiculos(1000);
		newLivro.setTipo("Novo Testamento");
		em.getTransaction().begin();
		em.persist(newLivro);
		em.getTransaction().commit();
		
		
		LeituraRealizada leitura = new LeituraRealizada();
		leitura.setCapitulo(1);
		leitura.setData(c);
		leitura.setVersiculo(10);
		leitura.setLogin(null);
		leitura.setLivros(null);
		
		//INSERIR DADOSDO OBJETO CRIADO ACIMA
		em.getTransaction().begin();
		em.persist(leitura);
		em.getTransaction().commit();
		 
	} */

}
