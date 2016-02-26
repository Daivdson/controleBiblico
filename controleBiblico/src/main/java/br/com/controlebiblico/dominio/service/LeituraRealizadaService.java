package br.com.controlebiblico.dominio.service;

import java.util.List;

import br.com.controlebiblico.dominio.entidade.LeituraRealizada;
import br.com.controlebiblico.dominio.repositorios.LeituraRealizadaRepositorio;

public class LeituraRealizadaService {
	private final LeituraRealizadaRepositorio repo = new LeituraRealizadaRepositorio();
	
	public LeituraRealizada buscarPorId(final Long id){
		return repo.buscarPorId(id);
	}
	
	public List<LeituraRealizada> buscarTodos(){
		return repo.buscarTodos();
	}
	
	public void excluir(LeituraRealizada leituraRealizada){
		repo.excluir(leituraRealizada);
	}
	
	public  LeituraRealizada salvarOuAtualizar(LeituraRealizada leituraRealizada){
		return repo.salvarOuAtualizar(leituraRealizada);
	}

}
