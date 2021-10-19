//package com.projeto.cafedamanha.repository;
//
//import java.util.List;
//
//import org.springframework.stereotype.Repository;
//
//import com.projeto.cafedamanha.model.Usuario;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//
//@Data
//@AllArgsConstructor
//@Repository
//public class UsuarioRepository {
//
//	private List<Usuario> usuarios;	
//	
//	public UsuarioRepository() {
//		super();
//		this.usuarios.add(new Usuario("1", "Nome", "999999999"));
//	}
//
//	public List<Usuario> getUsuarios() {
//		return usuarios;
//	}
//
//	public void setUsuarios(List<Usuario> usuarios) {
//		this.usuarios = usuarios;
//	}
//	
//	public List<Usuario> getUsuario(String id) {		
//		return usuarios.stream().filter(usuario -> usuario.getId() == id).toList();
//	}
//	
//	public void setUsuario(Usuario usuario) {
//		usuarios.add(usuario);
//	}
//
//	public void putUsuario(Usuario usuario) {
////		usuarios.stream().filter(usuario -> usuario.getId() == id).toArray();
//	}
//
//	public void deleteUsuario(String id) {
////		usuarios.(usuarios.stream().filter(user -> user.id != id).toArray());
//	}
//}
