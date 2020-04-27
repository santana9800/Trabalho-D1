package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Noticia;
import service.NoticiaService;



@WebServlet("/DeleteNot.do")
public class DeleteNot extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter saida = response.getWriter();
		// Capturando o parâmetro nome_contato
	     String id = request.getParameter("id_not");
		
		
		saida.println("Noticia Deletada");		
		int idNot = Integer.parseInt(id);
		
	
		Noticia noticia = new Noticia();
		noticia.setId(idNot );
		
		
		NoticiaService serv = new NoticiaService();
		
		serv.excluirNot(noticia);
		
	}

}
