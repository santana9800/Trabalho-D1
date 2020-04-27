package service;

import java.util.ArrayList;

import dao.ComentarioDAO;
import model.Comentario;

public class ComentarioService {
	
	

	
	Comentario comentario = new Comentario();
	ComentarioDAO comDAO = new ComentarioDAO();
	
	//CONDIÇÕES PARA QUE OS DADOS SEJAM ENVIADOS AO BANCO DE DADOS
	
	public void cadastrarCom(Comentario comentario) {
		
		if(comentario.getNome().length() > 500 &&comentario.getNome().length() < 4 ) {
			return;
		}
		if(comentario.getTexto().length() > 60 &&comentario.getTexto().length() < 3 ) {
			return;
		}
		if(comentario.getFk_noticia_id() == 0) {
			return;
		}
		if(comentario.getNome() ==null  || comentario.getTexto() == null ) {
			return; 
		}
		
		comDAO.cadastrar(comentario);
		

}
	
	public void excluirCom(Comentario comentario) {
		
		
		comDAO.excluir(comentario);
		

}
	
	public void alterarCom(Comentario comentario) {
		if(comentario.getId() == 0) {
			return;
		}
		if(comentario.getNome().length() > 500 &&comentario.getNome().length() < 4 ) {
			return;
		}
		if(comentario.getTexto().length() > 60 &&comentario.getTexto().length() < 3 ) {
			return;
		}
		if(comentario.getFk_noticia_id() == 0) {
			return;
		}
		if(comentario.getNome() ==null  || comentario.getTexto() == null ) {
			return; 
		}
		
		comDAO.alterar(comentario);
		

}
	
	//listar os professores do sistema
	public ArrayList<Comentario> listarCom() {
		comDAO.listarComentarios();
		
		return  comDAO.listarComentarios();
	}
	
	
	//consultar maricula de um prof
	public Comentario consulta(Comentario com) {
		
		if(com.getId()==0) {
			return null;
		}
		comDAO.consultar(com.getId());
		return  comDAO.consultar(com.getId());
	}

}


