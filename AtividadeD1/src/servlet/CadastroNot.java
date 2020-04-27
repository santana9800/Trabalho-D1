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


@WebServlet("/CadastroNot.do")
public class CadastroNot extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		

		
		// Capturando o parâmetro descricao_not
		String descricao = request.getParameter("descricao_not");
		// Capturando o parâmetro titulo_not
		String titulo = request.getParameter("titulo_not");
		// Capturando o parâmetro texto_not
		String texto = request.getParameter("texto_not");
		
		// Criando um objeto de saída de dados:
		PrintWriter saida = response.getWriter();
		
		
		saida.println("<b>Noticia Cadastrada</b><br><br>" +"Titulo: " + titulo + "<br> Descrição: " + descricao +" <br> Texto:" +  texto );
		
		Noticia not = new Noticia();
		not.setDescricao(descricao);
		not.setTitulo(titulo);
		not.setTexto(texto);
		
		NoticiaService serv = new NoticiaService();
		
		serv.cadastrarNot(not);
			}

}
