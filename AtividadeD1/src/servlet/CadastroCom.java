package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Comentario;
import service.ComentarioService;


@WebServlet("/CadastroCom.do")
public class CadastroCom extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Capturando o parâmetro descricao_not
		String nome = request.getParameter("nome_com");
		// Capturando o parâmetro titulo_not
		String texto = request.getParameter("texto_com");
		// Capturando o parâmetro texto_not
		String fk = request.getParameter("fk_com");
		
		// Criando um objeto de saída de dados:
		PrintWriter saida = response.getWriter();
		

		int fk_com = Integer.parseInt(fk);
		
		saida.println( "Nome: " + nome +"<br>"+" Id noticia: " + fk + "<br>"+"Comentario: " + texto);
		
		Comentario com = new Comentario();
		com.setNome(nome);
		com.setTexto(texto);
		com.setFk_noticia_id(fk_com);
		
		ComentarioService serv = new ComentarioService();
		
		serv.cadastrarCom(com);
		
		
		
		
		
		
		
		

	
		
		
		
	}

}
