package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Comentario;

public class ComentarioDAO {
private Connection conexao;
	
	public ComentarioDAO() {
		this.conexao = ConnectionFactory.conectar();
	}

	public void cadastrar(Comentario comentario) {
			
		String inserir = "INSERT INTO comentario "
				+ " ( nome, texto, fk_noticia_id) "
				+ " VALUES ( ?, ?, ?) ";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(inserir) ) {
			
			pst.setString(1, comentario.getNome());
			pst.setString(2, comentario.getTexto());
			pst.setInt(3, comentario.getFk_noticia_id());
			
			pst.execute();
			
		} catch (SQLException ex) {
			
			System.err.println("Nao foi possivel manipular "
					+ "a tabela comentario.");
			ex.printStackTrace();
			
		}
	}
	
	public void alterar(Comentario comentario) {
		
		String inserir = "UPDATE comentario "
				+ "SET nome = ?, texto = ?, texto = ? "
				+ " WHERE id = ? ";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(inserir) ) {
			
			pst.setInt(1, comentario.getId());
			pst.setString(2, comentario.getNome());
			pst.setString(3, comentario.getTexto());
			pst.setInt(4, comentario.getFk_noticia_id());
			
			pst.execute();
			
		} catch (SQLException ex) {
			
			System.err.println("Nao foi possivel manipular "
					+ "a tabela Comentario.");
			ex.printStackTrace();
			
		}
	}
	
	public void excluir(Comentario comentario) {
		
		String inserir = "DELETE FROM comentario "
				+ " WHERE id = ? ";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(inserir) ) {
			
			pst.setInt(1, comentario.getId());
			
			pst.execute();
			
		} catch (SQLException ex) {
			
			System.err.println("Nao foi possivel manipular "
					+ "a tabela Comentario.");
			ex.printStackTrace();
		}
	}
	
	public Comentario consultar(int id) {
		
		String inserir = "SELECT * FROM comentario "
				+ " WHERE id = ? ";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(inserir) ) {
			
			pst.setInt(1, id);
			ResultSet resultado = pst.executeQuery();
			
			Comentario n = new Comentario();
			if (resultado.next()) {
				n.setNome(resultado.getString("nome"));
				n.setTexto(resultado.getString("texto"));
				n.setId(id);
				n.setFk_noticia_id(resultado.getInt("fk_noticia_id"));
			}
			return n;
			
			
		} catch (SQLException ex) {
			
			System.err.println("Nao foi possivel manipular "
					+ "a tabela Comentario.");
			ex.printStackTrace();
			
			return null;
		}
	}

	
	public ArrayList<Comentario> listarComentarios() {
		
		String inserir = "SELECT * FROM comentario";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(inserir) ) {
			
			ResultSet resultado = pst.executeQuery();
			
			ArrayList<Comentario> lista = new ArrayList<>();
			while (resultado.next()) {
				Comentario n = new Comentario();
				n.setNome(resultado.getString("nome"));
				n.setTexto(resultado.getString("texto"));
				n.setId(resultado.getInt("id"));
				n.setFk_noticia_id(resultado.getInt("fk_noticia_id"));
				
				lista.add(n);
			}
			return lista;
			
		} catch (SQLException ex) {
			
			System.err.println("Nao foi possivel manipular "
					+ "a tabela Comentarios.");
			ex.printStackTrace();
			
			return null;
		}
	}
}
