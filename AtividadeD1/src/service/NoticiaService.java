package service;

import java.util.ArrayList;

import dao.NoticiaDAO;
import model.Noticia;

public class NoticiaService {
	
	Noticia noticia = new Noticia();
	NoticiaDAO notDAO = new NoticiaDAO();
	
	//CONDIÇÕES PARA QUE OS DADOS SEJAM ENVIADOS AO BANCO DE DADOS
	
	public void cadastrarNot(Noticia noticia) {
		
		if(noticia.getDescricao().length() > 500 &&noticia.getDescricao().length() < 4 ) {
			return;
		}
		if(noticia.getTitulo().length() > 60 &&noticia.getTitulo().length() < 3 ) {
			return;
		}
		if(noticia.getTexto().length() > 1000 &&noticia.getTexto().length() < 10 ) {
			return;
		}
		if(noticia.getTexto() ==null  || noticia.getDescricao() == null || noticia.getTitulo() == null) {
			return; 
		}
		
		notDAO.cadastrar(noticia);
		

}
	
	public void excluirNot(Noticia noticia) {
		
		
		notDAO.excluir(noticia);
		

}
	
	public void alterarNot(Noticia noticia) {
		if(noticia.getId() == 0) {
			return;
		}
		if(noticia.getDescricao().length() > 500 &&noticia.getDescricao().length() < 4 ) {
			return;
		}
		if(noticia.getTitulo().length() > 60 &&noticia.getTitulo().length() < 3 ) {
			return;
		}
		if(noticia.getTexto().length() > 1000 &&noticia.getTexto().length() < 1 ) {
			return;
		}
		if(noticia.getTexto() == null  || noticia.getDescricao() == null || noticia.getTitulo() == null) {
			return; 
		}
		
		notDAO.alterar(noticia);
		

}
	
	//listar os professores do sistema
	public ArrayList<Noticia> listarNot() {
		notDAO.listarNoticias();
		
		return  notDAO.listarNoticias();
	}
	
	
	//consultar maricula de um prof
	public Noticia consulta(Noticia not) {
		
		if(not.getId()==0) {
			return null;
		}
		notDAO.consultar(not.getId());
		return  notDAO.consultar(not.getId());
	}

}
