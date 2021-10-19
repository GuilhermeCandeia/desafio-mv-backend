package com.projeto.cafedamanha.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.cafedamanha.filters.FiltroDeItem;
import com.projeto.cafedamanha.model.Item;
import com.projeto.cafedamanha.model.Usuario;
import com.projeto.cafedamanha.model.UsuarioDTO;

@Service
public class UsuarioService {
	
	@Autowired
	private ItemService itemService;

	private List<Usuario> usuarios;	
	
	public UsuarioService() {
		super();
		this.usuarios = new ArrayList<Usuario>();
		this.usuarios.add(new Usuario("1", "Nome", "999999999"));
		this.usuarios.add(new Usuario("2", "Nome2", "88888888"));
	}
//	@Autowired
//	private UsuarioRepository repository;
//	
//	public List<Usuario> getUsuarios() {
//		return repository.getUsuarios();
//	}
//	
//	public List<Usuario> getUsuario(String id) {
//		return repository.getUsuario(id);
//	}
//	
//	public void setUsuario(Usuario usuario) {
//		repository.setUsuario(usuario);
//	}
//
//	public void putUsuario(Usuario usuario) {
//		repository.putUsuario(usuario);
//	}
//
//	public void deleteUsuario(String id) {
//		usuarios.(usuarios.stream().filter(user -> user.id != id).toArray());
//	}

	public List<UsuarioDTO> getUsuarios() {
		List<UsuarioDTO> listaUsuarios = usuarios.stream().map((usuario) -> {
			FiltroDeItem filtro = new FiltroDeItem();
			filtro.setIdUsuario(usuario.getId());
			
			List<Item> itens = itemService.getItens(filtro);
			UsuarioDTO usuarioDto = new UsuarioDTO(usuario.getId(), usuario.getNome(), usuario.getCpf());
			
			if (itens.size() > 0) {
				usuarioDto.setItem(itens.get(0));
			}
			
			return usuarioDto;
		}).toList();
		
		return listaUsuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	public List<Usuario> getUsuario(String id) {
		return usuarios.stream().filter(usuario -> usuario.getId().equals(id)).toList();
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuarios.add(usuario);
	}

	public void putUsuario(String id, Usuario usuario) {
		List<Usuario> novaLista = usuarios.stream().map((Usuario user) -> {
			if (user.getId().equals(id)) {
				return usuario;
			}
			return user;
		}).toList();
		
		usuarios.clear();
		usuarios.addAll(novaLista);
	}

	public void deleteUsuario(String id) {
		List<Usuario> novaLista = usuarios.stream().filter(usuario -> !usuario.getId().equals(id)).toList();
		
		usuarios.clear();
		usuarios.addAll(novaLista);
	}


}
