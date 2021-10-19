package com.projeto.cafedamanha.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.cafedamanha.model.Item;
import com.projeto.cafedamanha.model.NovoUsuario;
import com.projeto.cafedamanha.model.Usuario;
import com.projeto.cafedamanha.model.UsuarioDTO;
import com.projeto.cafedamanha.service.ItemService;
import com.projeto.cafedamanha.service.UsuarioService;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
public class UsuariosController {
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private ItemService itemService;
	
	@GetMapping("/usuarios")
	public List<UsuarioDTO> listarUsuarios() {
		return usuarioService.getUsuarios();
	}
	
	@GetMapping("/usuarios/{id}")
	public List<Usuario> detalharUsuario(@PathVariable String id) {
		return usuarioService.getUsuario(id);
	}
	
	@PostMapping("/usuarios")
	public ResponseEntity<NovoUsuario> criarUsuario(@RequestBody NovoUsuario novoUsuario) {
		Random random = new Random();
	    Integer id = random.ints(0,(100+1)).findFirst().getAsInt();		
	    novoUsuario.getUsuario().setId(id.toString());
		
		usuarioService.setUsuario(novoUsuario.getUsuario());
		itemService.vincularUsuarioAoItem(novoUsuario.getUsuario().getId(), novoUsuario.getItemId());
		
		return new ResponseEntity<>(novoUsuario, HttpStatus.CREATED);
	}
	
	@PutMapping("/usuarios/{id}")
	public ResponseEntity<NovoUsuario> atualizarUsuario(@PathVariable String id, @RequestBody NovoUsuario user) {
		usuarioService.putUsuario(id, user.getUsuario());
		
		if (user.getItemId() != null) {
			itemService.vincularUsuarioAoItem(id, user.getItemId());
		}
		return ResponseEntity.ok(user);
	}
	
	@PutMapping("/usuarios/{id}/vincular-item")
	public ResponseEntity<Item> vincularItem(@PathVariable String id, @RequestBody Item item) {
		itemService.vincularUsuarioAoItem(id, item.getId());
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/usuarios/{id}/desvincular-item")
	public ResponseEntity<Item> desvincularItem(@PathVariable String id) {
		itemService.desvincularUsuarioDoItem(id);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/usuarios/{id}")
    public ResponseEntity<?> excluir(@PathVariable String id) {
		itemService.desvincularUsuarioDoItem(id);
		usuarioService.deleteUsuario(id);

        return ResponseEntity.ok().build();
    }
}