package br.com.tetra.model;

public class Cliente {
	private int id;
	private String nome;
	private String email;
	private String endereco;
	private String telefone;
	private char sexo;
	private boolean newsLetter;
	
	public Cliente(int id, String nome, String email, String endereco, String telefone, char sexo, boolean newsLetter) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.endereco = endereco;
		this.telefone = telefone;
		this.sexo = sexo;
		this.newsLetter = newsLetter;
	}
	
	public Cliente(String nome, String email, String endereco, String telefone, char sexo, boolean newsLetter) {
		this.nome = nome;
		this.email = email;
		this.endereco = endereco;
		this.telefone = telefone;
		this.sexo = sexo;
		this.newsLetter = newsLetter;
	}

	public boolean isNewsLetter() {
		return newsLetter;
	}

	public void setNewsLetter(boolean newsLetter) {
		this.newsLetter = newsLetter;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {	
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public int getId() {
		return id;
	}	
}
