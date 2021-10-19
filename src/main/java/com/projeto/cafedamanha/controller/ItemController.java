package com.projeto.cafedamanha.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.cafedamanha.filters.FiltroDeItem;
import com.projeto.cafedamanha.model.Item;
import com.projeto.cafedamanha.service.ItemService;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
public class ItemController {
	@Autowired
	private ItemService itemService;
	
	@GetMapping("/itens")
	public List<Item> listarItens(FiltroDeItem filtros) {
		return itemService.getItens(filtros);
	}
}
