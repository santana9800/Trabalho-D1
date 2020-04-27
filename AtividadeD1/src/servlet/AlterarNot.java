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

@WebServlet("/AlterarNot.do")
public class AlterarNot extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Capturando o par�metro id_not
		String id = request.getParameter("id_not");
		// Capturando o par�metro descricao_not
		String descricao = request.getParameter("descricao_not");
		// Capturando o par�metro titulo_not
		String titulo = request.getParameter("titulo_not");
		// Capturando o par�metro texto_not
		String texto = request.getParameter("texto_not");
		
		// Criando um objeto de sa�da de dados:
		PrintWriter saida = response.getWriter();
		
		int idNot = Integer.parseInt(id);
		
		
		Noticia not = new Noticia();
		not.setId(idNot);
		not.setDescricao(descricao);
		not.setTitulo(titulo);
		not.setTexto(texto);
		
		NoticiaService serv = new NoticiaService();
		serv.alterarNot(not);
		saida.println("<b>Noticia Alterada</b><br><br>" + "Numero Noticia: " + idNot +"<br> Titulo: " + titulo + "<br> Descri��o:<br> " + descricao +" <br> Texto:<br>" +  texto );

	}
	

}
