package br.com.controlebiblico.infraestrutura.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("controleBiblico");
	
	public static EntityManager getEntityManager(){
		return emf.createEntityManager();
	}

}
