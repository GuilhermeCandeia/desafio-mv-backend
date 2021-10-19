package com.projeto.cafedamanha.model;

public class Item {
	
	private String id;
	
	private String nome;
	
	private String idUsuario;
	
	public Item() {
		super();
	}
	
	public Item(String id, String nome, String idUsuario) {
		super();
		this.id = id;
		this.nome = nome;
		this.idUsuario = idUsuario;
	}
	
	public String getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getIdUsuario() {
		return idUsuario;
	}
	
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
}
