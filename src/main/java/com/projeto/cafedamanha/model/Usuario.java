package com.projeto.cafedamanha.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	
	@NonNull
	private String nome;
	
	@NonNull
	private String cpf;
	
	public Usuario() {
		super();
	}	

	public Usuario(String id, @NonNull String nome, @NonNull String cpf) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
	}	

	public void setId(String id) {
		this.id = id;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}
