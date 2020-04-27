package model;

public class Comentario {
	
	//declaração de atributos
	private int id;
	private String nome;
	private String texto;
	private int fk_noticia_id;
	
	
	//construtores
	public Comentario() {}
	
	public Comentario(int id, String nome, String texto, int fk_noticia_id) {
		super();
		this.id = id;
		this.nome = nome;
		this.texto = texto;
		this.fk_noticia_id = fk_noticia_id;
	}
	
	//metodos de acesso
	public int getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	public String getTexto() {
		return texto;
	}
	
	public int getFk_noticia_id() {
		return fk_noticia_id;
	}
	
	//Metodos modificadores
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	public void setFk_noticia_id(int fk_noticia_id) {
		this.fk_noticia_id = fk_noticia_id;
	}

}
