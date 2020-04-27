package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Comentario;
import model.Noticia;
import service.ComentarioService;
import service.NoticiaService;


@WebServlet("/ListarNotCom.do")
public class ListarNotCom extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 PrintWriter saida = response.getWriter();
			
		    NoticiaService servN = new NoticiaService();
			ComentarioService serv = new ComentarioService();
			
			ArrayList<Noticia>lista = servN.listarNot();
			ArrayList<Comentario>lista2 = serv.listarCom();
			
			for(Noticia n : lista) {
				
				
				saida.println("<b>NOTICIA</b> <br>"
						+"<b>Nº noticia:</b> " + n.getId() 
						+ " <br> <b>Titulo:</b> <br>" + n.getTitulo()
						+ "<br> <b>Descrição:</b><br> " + n.getDescricao()
						+ "<br> <b>Texto:</b> <br> "+ n.getTexto()+ "<br> " + "<br> " );
				
				for(Comentario c : lista2) {
				if(c.getFk_noticia_id() == n.getId()) {
					
					saida.println( "<b>COMENTARIOS</b>"
							+ " <br> <b>Nome do comentarista:</b> " + c.getNome() 
							+ "<br> <b>Comentario:</b><br> "+ c.getTexto() + "<br>"+
							"<b>Nº Comentario:</b> " + c.getId() +
							"<br> <b>Nº Noticia:</b> " + c.getFk_noticia_id() + "<br> " + "<br>  <br>"  );
					
				}
				}
				
		
			}
			
			response.setContentType("text/html;charset=ISO-8859-1");
			
			saida.println("<!DOCTYPE html>"+
					"<html>"+
					"<head>"+
					"<meta charset=\"ISO-8859-1\">\r\n" + 
					"<title>Insert title here</title>"+
					"</head>"+
					"<body>"+

					"<h1> Cadastro Noticia</h1>"+
						 "	<form action=\"CadastroCom.do\" method=\"post\">\r\n" + 
					       "Digite seu nome:<br>"+
					      " <input type=\"text\" name = \"nome_com\"> <br><br>"+
					       
					       "Numero da Noticia:<br>"+
					      " <input type = \"text\" name = \"fk_com\"> <br><br> "+
					              
					       "Comentario:<br>"+
					       "<textarea type = \"text\" name = \"texto_com\" rows=\"10\" cols=\"30\"> </textarea> <br><br>"+
					      
					           
					      
					     " <input  value=\"Enviar comentario\" type =\"submit\">"+
					      "</form>"+

					"</body>"+
					"</html>");
	
		
		
	
	}

}
