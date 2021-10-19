package com.projeto.cafedamanha.model;

public class NovoUsuario {
	private Usuario usuario;
	private String itemId;
	
	public NovoUsuario(Usuario usuario, String itemId) {
		super();
		this.usuario = usuario;
		this.itemId = itemId;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public String getItemId() {
		return itemId;
	}
	
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
}
