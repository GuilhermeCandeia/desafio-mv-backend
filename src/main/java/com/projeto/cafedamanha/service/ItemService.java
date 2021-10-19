package com.projeto.cafedamanha.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.projeto.cafedamanha.filters.FiltroDeItem;
import com.projeto.cafedamanha.model.Item;

@Service
public class ItemService {

	private List<Item> itens;	
	
	public ItemService() {
		super();
		this.itens = new ArrayList<Item>();
		this.itens.add(new Item("1", "pão", null));
		this.itens.add(new Item("2", "melancia", null));
		this.itens.add(new Item("3", "melão", null));
		this.itens.add(new Item("4", "presunto", null));
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

	public List<Item> getItens(FiltroDeItem filtros) {
		if (filtros.isDisponivel()) {
			return itens.stream().filter(item -> item.getIdUsuario() == null).toList();
		}
		
		if (filtros.getIdUsuario() != null) {
			return itens.stream().filter(item -> 
				item.getIdUsuario() != null && item.getIdUsuario().equals(filtros.getIdUsuario())).toList();
		}
		
		return itens;
	}
	
	public void vincularUsuarioAoItem(String usuarioId, String itemId) {
		List<Item> novaLista = itens.stream().map((Item item) -> {
			if (item.getId().equals(itemId)) {
				item.setIdUsuario(usuarioId);
				return item;
			}
			return item;
		}).toList();
		
		itens.clear();
		itens.addAll(novaLista);
	}

	public void desvincularUsuarioDoItem(String usuarioId) {
		List<Item> novaLista = itens.stream().map((Item item) -> {
			if (item.getIdUsuario() != null && item.getIdUsuario().equals(usuarioId)) {
				item.setIdUsuario(null);
				return item;
			}
			return item;
		}).toList();
		
		itens.clear();
		itens.addAll(novaLista);
	}


}
